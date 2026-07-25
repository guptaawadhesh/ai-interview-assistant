package com.awadhesh.ai.service.impl;

import com.awadhesh.ai.config.GeminiProperties;
import com.awadhesh.ai.dto.GeminiRequest;
import com.awadhesh.ai.dto.GeminiResponse;
import com.awadhesh.ai.service.GeminiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GeminiServiceImpl implements GeminiService {

    private final RestClient restClient;
    private final GeminiProperties properties;

    public GeminiServiceImpl(RestClient restClient,
                             GeminiProperties properties) {
        this.restClient = restClient;
        this.properties = properties;
    }

    @Override
    public String generateContent(String prompt) {

        GeminiRequest request = new GeminiRequest(
                List.of(
                        new GeminiRequest.Content(
                                List.of(
                                        new GeminiRequest.Part(prompt)
                                )
                        )
                )
        );

        GeminiResponse response = restClient.post()
                .uri(uriBuilder ->
                        uriBuilder.queryParam("key", properties.apiKey()).build())
                .body(request)
                .retrieve()
                .body(GeminiResponse.class);

        if (response == null) {
            throw new RuntimeException("No response received from Gemini API");
        }

        return response.text();
    }
}