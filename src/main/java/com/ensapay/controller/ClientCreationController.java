package com.ensapay.controller;

import com.ensapay.entity.Client;
import com.ensapay.service.ClientCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientCreationController {

    @Autowired
    private ClientCreationService clientCreationService;

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody Client client)
    {
        return clientCreationService.saveClient(client);
    }




}
