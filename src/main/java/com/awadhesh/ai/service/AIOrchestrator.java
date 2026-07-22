package com.awadhesh.ai.service;

import com.awadhesh.ai.client.AIProvider;
import com.awadhesh.ai.client.AIProviderResolver;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.strategy.AIProviderSelectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AIOrchestrator {

    private static final Logger logger =
            LoggerFactory.getLogger(AIOrchestrator.class);

    private final AIProviderResolver providerResolver;

    private final AIProviderSelectionStrategy selectionStrategy;

    public AIOrchestrator(
            AIProviderSelectionStrategy selectionStrategy,
            AIProviderResolver providerResolver) {

        this.selectionStrategy = selectionStrategy;
        this.providerResolver = providerResolver;
    }



    public String ask(AskRequest request) {

        String providerName =
                selectionStrategy.selectProvider(request);

        logger.info("Executing prompt using provider: {}", providerName);

        long startTime = System.currentTimeMillis();

            AIProvider aiProvider =
                    providerResolver.resolve(providerName);

        String response = aiProvider.generateResponse(request.prompt());

        long endTime = System.currentTimeMillis();

        logger.info("AI response generated in {} ms",
                endTime - startTime);

            return response;
    }
}