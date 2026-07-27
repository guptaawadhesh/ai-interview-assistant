package com.awadhesh.ai.dto.resume.rewrite;

import jakarta.validation.constraints.NotBlank;

public record ResumeRewriteRequest(

        @NotBlank
        String resume

) {
}
