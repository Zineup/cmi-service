package com.ensapay.repository.orange;

import com.ensapay.entity.orange.Facture;
import com.ensapay.entity.orange.PayFactureClient;

import java.util.List;


public interface FactureOrangeRepository {

    public List<Facture> getAllFacturesByReferenceId(String referenceId);
    public void payFactures(PayFactureClient payFactureClient);
}
