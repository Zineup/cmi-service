package com.ensapay.service;

import com.ensapay.entity.*;
import com.ensapay.repository.ClientCreationRepository;
import com.ensapay.repository.CmiClientRepository;
import com.ensapay.repository.CreancierOrangeRepository;
import com.ensapay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CreancierOrangeService {

    private static final String URL_GET_ALL_FACTURES_BY_REFERENCE_ID = "http://68.183.138.82:5000/api/factures/getfactures?referenceId=";

    private static final String URL_PAY_LIST_OF_FACTURES = "http://68.183.138.82:5000/api/factures/payfactures";

    CreancierOrangeRepository creancierOrangeRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ClientCreationRepository clientCreationRepository;
    @Autowired
    private CmiClientRepository cmiClientRepository;


    public List<Facture> getAllFacturesByReferenceId(String referenceId) {
        Facture[] factures = restTemplate.getForEntity(URL_GET_ALL_FACTURES_BY_REFERENCE_ID + referenceId, Facture[].class).getBody();

        List<Facture> listFactures = Arrays.asList(factures);

        List<Facture> listFacturesNonPayees = listFactures.stream().filter(f->(!f.getStatut().equals("PAID"))).collect(Collectors.toList());
        return listFacturesNonPayees;
    }


    public ResponseEntity<String> payFactures(PayFactureClient payFactureClient){

        String clientId = payFactureClient.getClient_id();
        Client ensaPayClient;
        CmiClient cmiClient;

        //try to get Client, sinon on retourne badRequest
        try{
            ensaPayClient = clientCreationRepository.findById(clientId).get();
            cmiClient = cmiClientRepository.findByTel(ensaPayClient.getClientTel()).get();
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Client Id non valid");
        }

        //Si on a trouvé le client, on essaie de stocker les factures à payer dans une liste

        List<Facture> factures = getAllFacturesByReferenceId(payFactureClient.getReference_id());
        List<String> idFacturesPayees = Arrays.asList(payFactureClient.getFacture_ids());
        List<String> idFacturesOrange = new ArrayList<>();
        List<Facture> facturesPayees = new ArrayList<>();

        int somme = 0;
        int plafond = Integer.parseInt(ensaPayClient.getClientAccountType());

        //Récuperer les factures payées
        for (Facture f:factures) {

            if(idFacturesPayees.contains(f.getId())){

                facturesPayees.add(f);
                somme += f.getMontant();
                idFacturesOrange.add(f.getId());
            }
        }

        System.out.println(somme);

        //faire la transaction
        if(somme <= plafond && somme > 0) {

            if(cmiClient.getSolde() >= somme) {

                cmiClient.setSolde(cmiClient.getSolde() - somme);
                cmiClientRepository.save(cmiClient);

                Transaction transaction = new Transaction();
                transaction.setClientId(ensaPayClient.getId());
                transaction.setPayFactureClient(payFactureClient);
                Transaction savedTransaction = transactionRepository.save(transaction);

                PayFactureOrange payFactureOrange = new PayFactureOrange();
                payFactureOrange.setFacture_ids(idFacturesOrange.toArray(new String[idFacturesOrange.size()]));
                payFactureOrange.setReference_id(payFactureClient.getReference_id());
                payFactureOrange.setTransactionnal_id(savedTransaction.getId());

                ResponseEntity<?> status = restTemplate.postForEntity(URL_PAY_LIST_OF_FACTURES, payFactureOrange, PayFactureOrange.class);
                System.out.println(status.getStatusCode().toString());

                return ResponseEntity.ok().body("La transaction a bien passé");

            } else {
                return ResponseEntity.badRequest().body("Vous avez pas assez de solde pour cette opération");
            }

        }
        //S'il n'ya pas de factures valides pour payer
        else if (somme == 0 || facturesPayees.size() == 0){

            return ResponseEntity.badRequest().body("Sélectionnez des factures valides à payer");

        } else {

            return ResponseEntity.badRequest().body("Vous avez dépassez le plafond de votre compte qui est limité à : " + ensaPayClient.getClientAccountType());

        }

    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
