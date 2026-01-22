package com.example.lifecompass.controller;

import com.example.lifecompass.model.DecisionDocument;
import com.example.lifecompass.service.DecisionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/decisions")
public class DecisionController {

    private final DecisionService service;

    public DecisionController(DecisionService service) {
        this.service = service;
    }

    @PostMapping
    public DecisionDocument createDecision(
            @RequestParam String mood,
            @RequestParam int energy,
            @RequestParam int time) {

        return service.createDecision(mood, energy, time);

    }
    @GetMapping
    public List<DecisionDocument> getAllDecisions() {
        return service.getAllDecisions();
    }
}

