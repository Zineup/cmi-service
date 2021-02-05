package com.ensapay.entity.orange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayFactureOrange {

    private String reference_id;
    private String[] facture_ids;
    private String transactionnal_id;
}
