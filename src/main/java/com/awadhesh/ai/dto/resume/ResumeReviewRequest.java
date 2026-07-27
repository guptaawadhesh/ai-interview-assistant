package com.awadhesh.ai.dto.resume;

import jakarta.validation.constraints.NotBlank;

public record ResumeReviewRequest(

        @NotBlank
        String resume

) {
}
