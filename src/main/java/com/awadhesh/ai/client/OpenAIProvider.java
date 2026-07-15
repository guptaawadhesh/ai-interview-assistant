package com.awadhesh.ai.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component("openai")
public class OpenAIProvider implements AIProvider {
    @Override
    public String generateResponse(String prompt) {
        return "OpenAI";
    }
}
