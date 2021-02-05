package com.ensapay.repository;

import com.ensapay.entity.Client;
import com.ensapay.entity.CmiClient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientCreationRepository extends MongoRepository<Client, String> {

    Optional<Client> findByClientTel (String tel);
}
