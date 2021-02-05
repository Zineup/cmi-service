package com.ensapay.service;

import com.ensapay.entity.Client;
import com.ensapay.entity.CmiClient;
import com.ensapay.repository.ClientCreationRepository;
import com.ensapay.repository.CmiClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCreationService {

    @Autowired
    private ClientCreationRepository clientCreationRepository;
    @Autowired
    private CmiClientRepository cmiClientRepository;

    public ResponseEntity<String> saveClient(Client client)
    {
        Optional<CmiClient> cmiClientOptional  = cmiClientRepository.findByTel(client.getClientTel());

        //check if this client has an account in CMI
        if(cmiClientOptional.isPresent()) {

            Optional<Client> clientOptional = clientCreationRepository.findByClientTel(client.getClientTel());

            //check if this client has not an account in ENSAPAY
            if (!clientOptional.isPresent()) {
                try{
                    client.setId(null);
                    clientCreationRepository.save(client);
                    return  ResponseEntity.accepted().body("OK");

                } catch (Exception e){

                    return ResponseEntity.badRequest().body("BAD REQUEST");
                }
            }
        }

        return ResponseEntity.badRequest().body("BAD REQUEST");

    }

}
