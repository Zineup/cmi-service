package com.ensapay;

import com.ensapay.service.CmiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CmiServiceApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(CmiServiceApplication.class, args);
    }

    @Autowired
    private CmiClientService cmiClientService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cmiClientService.saveClients());
    }
}
