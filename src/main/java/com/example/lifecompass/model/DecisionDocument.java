package com.example.lifecompass.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "decisions")
public class DecisionDocument {

    @Id
    private String id;

    private String mood;
    private int energyLevel;
    private int freeTime;

    private String suggestion;
    private int confidence;

    private LocalDateTime createdAt;

    public DecisionDocument() {}

    // getters & setters (or Lombok)
}

