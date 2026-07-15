package com.awadhesh.ai.client;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AIProviderResolver {

    private final Map<String, AIProvider> providers;

    public AIProviderResolver(Map<String, AIProvider> providers) {
        this.providers = providers;
    }

    public AIProvider resolve(String providerName) {

        AIProvider provider = providers.get(providerName);

        if (provider == null) {
            throw new IllegalArgumentException(
                    "Unsupported AI Provider : " + providerName);
        }

        return provider;
    }
}