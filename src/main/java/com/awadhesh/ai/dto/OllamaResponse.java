package com.awadhesh.ai.dto;

public record OllamaResponse(
        String model,
        String response,
        boolean done
) {
}
