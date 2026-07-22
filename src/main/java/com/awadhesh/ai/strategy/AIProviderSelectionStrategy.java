package com.awadhesh.ai.strategy;

import com.awadhesh.ai.dto.AskRequest;

public interface AIProviderSelectionStrategy {
    String selectProvider(AskRequest request);
}
