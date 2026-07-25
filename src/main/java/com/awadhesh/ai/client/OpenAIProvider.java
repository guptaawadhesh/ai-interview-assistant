package com.awadhesh.ai.client;

import com.awadhesh.ai.dto.AIResponse;
import org.springframework.stereotype.Component;

@Component("openai")
public class OpenAIProvider implements AIProvider {
    @Override
    public AIResponse generateResponse(String prompt) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getProviderName() {
        return "openAI";
    }
}
