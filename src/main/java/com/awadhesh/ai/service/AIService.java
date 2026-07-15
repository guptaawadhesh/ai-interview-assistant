package com.awadhesh.ai.service;

import com.awadhesh.ai.client.AIProvider;
import com.awadhesh.ai.client.AIProviderResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private static final Logger logger =
            LoggerFactory.getLogger(AIService.class);

    private final AIProviderResolver resolver;

    public AIService(AIProviderResolver resolver) {
        this.resolver = resolver;
    }

    public String ask(String providerName, String prompt) {

        logger.info("Generating AI response using provider: {}", providerName);

        long startTime = System.currentTimeMillis();

        AIProvider aiProvider = resolver.resolve(providerName);

        String response = aiProvider.generateResponse(prompt);

        long endTime = System.currentTimeMillis();

        logger.info("AI response generated in {} ms",
                endTime - startTime);

        return response;
    }
}