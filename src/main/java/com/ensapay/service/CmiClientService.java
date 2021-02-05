package com.ensapay.service;

import com.ensapay.entity.CmiClient;
import com.ensapay.repository.CmiClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CmiClientService {

    @Autowired
    private CmiClientRepository cmiClientRepository;


    List<CmiClient> cmiClients;

    public CmiClientService() {

            CmiClient cmiClient1 = new CmiClient(null, "Zineb", "KHALIS", "gmail", "0000", "adresse1", 1000, "CIH", new Date());

            CmiClient cmiClient2 = new CmiClient(null, "Imane", "Abouakil", "gmail", "0000", "adresse2", 1000, "CIH", new Date());

            CmiClient cmiClient3 = new CmiClient(null, "Hafsa", "Elgarda", "hafsa.elgarda@gmail.com", "0685858587", "adresse1", 2589, "BMCE", new Date());

            CmiClient cmiClient4 = new CmiClient(null, "Zineb", "Jnaini", "zineb.jnaini@gmail.com", "0685858588", "adresse1", 1000, "CIH", new Date());

            CmiClient cmiClient5 = new CmiClient(null, "Majda", "Zait", "majda.zait@gmail.com", "06858585888", "adresse1", 9866, "BMCI", new Date());

            CmiClient cmiClient6 = new CmiClient(null, "Mouad", "Sifane", "mouad.sifane@gmail.com", "0685858985", "adresse1", 10866, "BMCE", new Date());

            CmiClient cmiClient7 = new CmiClient(null, "Najwa", "Rabih", "najwa.rabih@gmail.com", "068599985", "adresse1", 10089, "CIH", new Date());

            CmiClient cmiClient8 = new CmiClient(null, "Mehdi", "Moutrib", "mehdi.moutrib@gmail.com", "0685844485", "adresse1", 18909, "BMCI", new Date());

        CmiClient cmiClient9 = new CmiClient();
        cmiClient9.setLastName("Kamili");
        cmiClient9.setFirstName("taha");
        cmiClient9.setEmail("kamili.taha@gmail.com");
        cmiClient9.setTel("05232323");
        cmiClient9.setAdresse("adresse9");
        cmiClient9.setBanque("CIH");

            this.cmiClients = new ArrayList<CmiClient>();
            this.cmiClients.add(cmiClient1);
            this.cmiClients.add(cmiClient2);
            this.cmiClients.add(cmiClient3);
            this.cmiClients.add(cmiClient4);
            this.cmiClients.add(cmiClient5);
            this.cmiClients.add(cmiClient6);
            this.cmiClients.add(cmiClient7);
            this.cmiClients.add(cmiClient8);
            this.cmiClients.add(cmiClient9);

    }

    public String saveClients()
    {
        if(cmiClientRepository.findAll().size() > 0)
            return "base de données déjà remplie";

        for (CmiClient cmiClient : this.cmiClients)
        {
            try{
                cmiClientRepository.save(cmiClient);
            } catch (Exception e){
                System.out.println("On a un client avec le même tel et email que ce client " + cmiClient);
            }
        }
        return "bien";
    }

}
