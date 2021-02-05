package com.ensapay.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Facture {

    private String id;
    private String referenceId;
    private String transactionId;
    private int montant;
    private String statut;
    private Date dateFacture;
    private Date datePaiment;

}
