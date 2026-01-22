package com.example.lifecompass.controller;

import com.example.lifecompass.model.DecisionDocument;
import com.example.lifecompass.service.DecisionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.lifecompass.dto.DecisionRequest;
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.data.domain.Page;






@RestController
@RequestMapping("/api/decisions")
public class DecisionController {

    private final DecisionService service;

    public DecisionController(DecisionService service) {
        this.service = service;
    }
    @PostMapping
    public DecisionDocument createDecision(@Valid @RequestBody DecisionRequest request) {
        return service.createDecision(
                request.getMood(),
                request.getEnergy(),
                request.getTime()
        );
    }
    @GetMapping
    public List<DecisionDocument> getAllDecisions() {
        return service.getAllDecisions();
    }
    @GetMapping("/latest")
    public DecisionDocument getLatestDecision() {
        return service.getLatestDecision()
                .orElseThrow(() -> new RuntimeException("No decisions found"));
    }
    @GetMapping("/paged")
    public Page<DecisionDocument> getDecisionsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getDecisionsPaged(page, size);
    }
}

