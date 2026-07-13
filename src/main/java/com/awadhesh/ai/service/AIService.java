package com.awadhesh.ai.service;

import com.awadhesh.ai.client.OllamaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private static final Logger logger =
            LoggerFactory.getLogger(AIService.class);

    private final OllamaClient ollamaClient;

    public AIService(OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    public String ask(String prompt) {

        logger.info("Generating AI response...");

        long startTime = System.currentTimeMillis();

        String response = ollamaClient.ask(prompt);

        long endTime = System.currentTimeMillis();

        logger.info("AI response generated in {} ms",
                endTime - startTime);

        return response;
    }
}