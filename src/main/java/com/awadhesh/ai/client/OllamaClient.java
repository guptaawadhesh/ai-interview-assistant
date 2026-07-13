package com.awadhesh.ai.client;

import com.awadhesh.ai.config.OllamaProperties;
import com.awadhesh.ai.dto.OllamaRequest;
import com.awadhesh.ai.dto.OllamaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OllamaClient {

    private static final Logger logger =
            LoggerFactory.getLogger(OllamaClient.class);

    private final WebClient webClient;
    private final OllamaProperties ollamaProperties;

    public OllamaClient(WebClient webClient,
                        OllamaProperties ollamaProperties) {

        this.webClient = webClient;
        this.ollamaProperties = ollamaProperties;
    }

    public String ask(String prompt) {

        long startTime = System.currentTimeMillis();

        logger.info("Calling Ollama model: {}", ollamaProperties.model());

        OllamaRequest request = new OllamaRequest(
                ollamaProperties.model(),
                prompt
        );

        OllamaResponse response = webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OllamaResponse.class)
                .block();

        long endTime = System.currentTimeMillis();

        logger.info("Ollama responded in {} ms",
                endTime - startTime);

        return response.response();
    }
}