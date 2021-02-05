package com.ensapay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Document("Transactions")
public class Transaction {

    @Id
    private String id;
    private String clientId;
    private PayFactureClient payFactureClient;
    @CreatedDate
    private Date dateTransaction;
}
