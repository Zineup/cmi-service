package com.ensapay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Document(collection = "ClientsEnsaPay")
public class Client {

    @Id
    private String id;
    private String clientFirstName;
    private String clientLastName;
    @Indexed(unique = true)
    private String clientEmail;
    @Indexed(unique = true)
    private String clientTel;
    private String clientAccountType;
    private String agentId;

}
