package com.ensapay.entity.orange;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recharge {

    private String id;
    private String transactionnalId;
    private String phoneNumber;
    private String description;
    private String transactionDate;
    private String montant;

}
