package com.example.lifecompass.controller;

import com.example.lifecompass.model.DecisionDocument;
import com.example.lifecompass.service.DecisionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.lifecompass.dto.DecisionRequest;
import jakarta.validation.Valid;

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
}

