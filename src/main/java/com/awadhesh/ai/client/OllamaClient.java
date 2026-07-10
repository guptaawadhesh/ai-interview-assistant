package com.awadhesh.ai.client;

import com.awadhesh.ai.dto.OllamaRequest;
import com.awadhesh.ai.dto.OllamaResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OllamaClient {

    private final WebClient webClient;

    public OllamaClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:11434").build();
    }

    public OllamaResponse ask(String prompt) {

        OllamaRequest request = new OllamaRequest(
                "gemma3:4b",
                prompt,
                false
        );

        return webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OllamaResponse.class)
                .block();
    }
}
