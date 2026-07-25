package com.awadhesh.ai.dto.interview;

import com.awadhesh.ai.enums.Difficulty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InterviewQuestionRequest(

        @NotBlank
        String role,

        @Min(0)
        Integer experience,

        @NotBlank
        String topic,

        @NotNull
        Difficulty difficulty,

        @Min(1)
        @Max(20)
        Integer count

) {
}