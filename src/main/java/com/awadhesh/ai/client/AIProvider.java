package com.awadhesh.ai.client;

import com.awadhesh.ai.dto.AIResponse;

public interface AIProvider {

    AIResponse generateResponse(String prompt);
    String getProviderName();

}