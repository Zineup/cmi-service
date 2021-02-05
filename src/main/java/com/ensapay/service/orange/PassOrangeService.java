package com.ensapay.service.orange;

import com.ensapay.entity.orange.Facture;
import com.ensapay.entity.orange.Pass;
import com.ensapay.repository.orange.FactureOrangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PassOrangeService {

    private static final String URL_GET_ALL_PASSES = "http://68.183.138.82:5000/api/passes";
    private static final String URL_GET_PASS_BY_ID = "http://68.183.138.82:5000/api/passes/";

    @Autowired
    RestTemplate restTemplate;

    public List<Pass> getAllPass()
    {
        Pass[] passes = restTemplate.getForEntity(URL_GET_ALL_PASSES, Pass[].class).getBody();
        return Arrays.asList(passes);
    }

    public Pass getPassById(String passId)
    {
        Pass pass = restTemplate.getForEntity(URL_GET_PASS_BY_ID + passId, Pass.class).getBody();
        return pass;
    }


}
