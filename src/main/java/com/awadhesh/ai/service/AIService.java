package com.awadhesh.ai.service;

import com.awadhesh.ai.client.OllamaClient;
import com.awadhesh.ai.dto.OllamaRequest;
import com.awadhesh.ai.dto.OllamaResponse;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final OllamaClient ollamaClient;

    public AIService(OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    public OllamaResponse ask(String prompt) {
      return ollamaClient.ask(prompt);
    }
}
