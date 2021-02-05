package com.ensapay.controller;

import com.ensapay.entity.Facture;
import com.ensapay.entity.PayFactureClient;
import com.ensapay.entity.Transaction;
import com.ensapay.service.CreancierOrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factures")
public class CreancierOrangeController {

    @Autowired
    private CreancierOrangeService creancierOrangeService;

    @GetMapping()
    public List<Facture> getAllFacturesByReferenceId(@RequestParam String referenceId){
        return creancierOrangeService.getAllFacturesByReferenceId(referenceId);
    }

    @PostMapping("payFactures")
    public ResponseEntity<String> payFactures(@RequestBody PayFactureClient payFactureClient){

        return creancierOrangeService.payFactures(payFactureClient);

    }
}
