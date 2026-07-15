package com.awadhesh.ai.dto;

import jakarta.validation.constraints.NotBlank;

public record AskRequest(

        @NotBlank(message = "Provider cannot be blank")
        String provider,

        @NotBlank(message = "Prompt cannot be blank")
        String prompt
) {}
