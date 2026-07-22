package com.awadhesh.ai.strategy;

import com.awadhesh.ai.config.AIProperties;
import com.awadhesh.ai.dto.AskRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultAIProviderSelectionStrategy implements AIProviderSelectionStrategy {

    private final AIProperties aiProperties;
    public DefaultAIProviderSelectionStrategy(AIProperties aiProperties) {
        this.aiProperties = aiProperties;
    }

    @Override
    public String selectProvider(AskRequest request) {
        return aiProperties.defaultProvider();
    }
}
