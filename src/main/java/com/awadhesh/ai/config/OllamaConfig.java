package com.awadhesh.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OllamaConfig {

    @Bean
    public WebClient webClient(OllamaProperties ollamaProperties) {

        return WebClient.builder()
                .baseUrl(ollamaProperties.baseUrl())
                .build();
    }
}