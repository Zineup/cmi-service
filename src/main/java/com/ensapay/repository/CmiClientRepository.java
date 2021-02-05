package com.ensapay.repository;

import com.ensapay.entity.Client;
import com.ensapay.entity.CmiClient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CmiClientRepository extends MongoRepository<CmiClient, String> {

    Optional<CmiClient> findByTel (String tel);

}
