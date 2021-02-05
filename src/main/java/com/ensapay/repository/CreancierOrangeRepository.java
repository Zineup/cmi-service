package com.ensapay.repository;

import com.ensapay.entity.Facture;
import com.ensapay.entity.PayFactureClient;
import com.ensapay.entity.PayFactureOrange;

import java.util.List;


public interface CreancierOrangeRepository {

    public List<Facture> getAllFacturesByReferenceId(String referenceId);
    public void payFactures(PayFactureClient payFactureClient);
}
