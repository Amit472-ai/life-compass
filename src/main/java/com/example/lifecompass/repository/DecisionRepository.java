package com.example.lifecompass.repository;

import com.example.lifecompass.model.DecisionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DecisionRepository
        extends MongoRepository<DecisionDocument, String> {
}

