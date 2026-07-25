package com.awadhesh.ai.dto;

import java.util.List;

public record GeminiResponse(
        List<Candidate> candidates,
        UsageMetadata usageMetadata,
        String modelVersion
) {

    public String text() {
        if (candidates == null || candidates.isEmpty()) {
            return "";
        }

        Candidate candidate = candidates.getFirst();

        if (candidate.content() == null
                || candidate.content().parts() == null
                || candidate.content().parts().isEmpty()) {
            return "";
        }

        return candidate.content().parts().getFirst().text();
    }

    public record Candidate(
            Content content,
            String finishReason,
            int index
    ) {}

    public record Content(
            List<Part> parts
    ) {}

    public record Part(
            String text
    ) {}

    public record UsageMetadata(
            int promptTokenCount,
            int candidatesTokenCount,
            int totalTokenCount
    ) {}
}