package com.example.lifecompass.service;

import com.example.lifecompass.model.DecisionDocument;
import com.example.lifecompass.repository.DecisionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;



@Service
public class DecisionService {

    private final DecisionRepository repository;
    private final Random random = new Random();

    public DecisionService(DecisionRepository repository) {
        this.repository = repository;
    }
    public List<DecisionDocument> getAllDecisions() {
        return repository.findAll();
    }
    public Optional<DecisionDocument> getLatestDecision() {
        return repository.findTopByOrderByCreatedAtDesc();
    }

    public DecisionDocument createDecision(
            String mood, int energy, int time) {

        DecisionDocument doc = new DecisionDocument();
        doc.setMood(mood);
        doc.setEnergyLevel(energy);
        doc.setFreeTime(time);

        doc.setSuggestion("Take it slow and focus on basics");
        doc.setConfidence(60 + random.nextInt(30));
        doc.setCreatedAt(LocalDateTime.now());

        return repository.save(doc);
    }
    public Page<DecisionDocument> getDecisionsPaged(int page, int size) {
        return repository.findAll(
                PageRequest.of(
                        page,
                        size,
                        Sort.by(Sort.Direction.DESC, "createdAt")
                )
        );
    }
}
