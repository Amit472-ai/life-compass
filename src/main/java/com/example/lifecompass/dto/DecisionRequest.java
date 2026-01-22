package com.example.lifecompass.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DecisionRequest {

    @NotBlank(message = "Mood cannot be empty")
    private String mood;

    @Min(value = 1, message = "Energy must be at least 1")
    @Max(value = 5, message = "Energy cannot be more than 5")
    private int energy;

    @Min(value = 0, message = "Time cannot be negative")
    @Max(value = 10, message = "Time too large")
    private int time;
}


