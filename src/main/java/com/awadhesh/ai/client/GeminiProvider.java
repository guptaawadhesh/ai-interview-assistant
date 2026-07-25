package com.awadhesh.ai.client;

import com.awadhesh.ai.config.GeminiProperties;
import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.GeminiRequest;
import com.awadhesh.ai.dto.GeminiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Component("gemini")
public class GeminiProvider implements AIProvider {

    private final WebClient webClient;
    private final GeminiProperties geminiProperties;
    private static final Logger logger =
            LoggerFactory.getLogger(GeminiProvider.class);

    public GeminiProvider(WebClient webClient,
                          GeminiProperties geminiProperties) {

        this.webClient = webClient;
        this.geminiProperties = geminiProperties;
    }

    @Override
    public AIResponse generateResponse(String prompt) {

        logger.info("Calling Gemini model: {}", geminiProperties.model());

        long startTime = System.currentTimeMillis();

        GeminiRequest request = new GeminiRequest(
                List.of(new GeminiRequest.Content(
                List.of(new GeminiRequest.Part(prompt))
        )));

        String endpoint = "/v1beta/models/"
                + geminiProperties.model()
                + ":generateContent";


        try {

            GeminiResponse response = webClient.post()
                    .uri(geminiProperties.baseUrl() + endpoint)
                    .header("X-goog-api-key", geminiProperties.apiKey())
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(GeminiResponse.class)
                    .block();

            if (response == null) {
                throw new IllegalStateException("No response received from Gemini");
            }

            return new AIResponse(
                    response.text(),
                    "gemini",
                    response.modelVersion()
            );

        } catch (WebClientResponseException ex) {

            logger.error("Status : {}", ex.getStatusCode());
            logger.error("Body   : {}", ex.getResponseBodyAsString());

            throw ex;
        }




    }

    @Override
    public String getProviderName() {

        return "gemini";
    }
}