package com.awadhesh.ai.client;

import com.awadhesh.ai.config.OllamaProperties;
import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.OllamaRequest;
import com.awadhesh.ai.dto.OllamaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Component("ollama")
public class OllamaProvider implements AIProvider {

    private static final Logger logger =
            LoggerFactory.getLogger(OllamaProvider.class);

    private final WebClient webClient;
    private final OllamaProperties ollamaProperties;

    public OllamaProvider(WebClient webClient,
                          OllamaProperties ollamaProperties) {

        this.webClient = webClient;
        this.ollamaProperties = ollamaProperties;
    }

    @Override
    public AIResponse generateResponse(String prompt) {

        long startTime = System.currentTimeMillis();

        logger.info("Calling Ollama model: {}", ollamaProperties.model());

        OllamaRequest request = new OllamaRequest(
                ollamaProperties.model(),
                prompt
        );

        OllamaResponse response = webClient.post()
                .uri(ollamaProperties.baseUrl() + "/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OllamaResponse.class)
                .block();

        long endTime = System.currentTimeMillis();

        logger.info("Ollama responded in {} ms",
                endTime - startTime);

        Objects.requireNonNull(response,
                "Ollama returned empty response");

        return new AIResponse(
                response.response(),
                "ollama",
                ollamaProperties.model()
        );
    }

    @Override
    public String getProviderName() {
        return "ollama";
    }


}