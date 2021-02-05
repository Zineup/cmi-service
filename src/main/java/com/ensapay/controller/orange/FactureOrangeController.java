package com.ensapay.controller.orange;

import com.ensapay.entity.orange.Facture;
import com.ensapay.entity.orange.PayFactureClient;
import com.ensapay.service.orange.FactureOrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orange/factures")
public class FactureOrangeController {

    @Autowired
    private FactureOrangeService factureOrangeService;

    @GetMapping()
    public List<Facture> getAllFacturesByReferenceId(@RequestParam String referenceId){
        return factureOrangeService.getAllFacturesByReferenceId(referenceId);
    }

    @PostMapping("payFactures")
    public ResponseEntity<String> payFactures(@RequestBody PayFactureClient payFactureClient){

        return factureOrangeService.payFactures(payFactureClient);

    }
}
