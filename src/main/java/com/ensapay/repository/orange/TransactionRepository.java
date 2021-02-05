package com.ensapay.repository.orange;

import com.ensapay.entity.orange.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
