package com.awadhesh.ai.dto.jd;

import jakarta.validation.constraints.NotBlank;

public record JDReviewRequest(

        @NotBlank
        String jobDescription

) {
}