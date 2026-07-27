package com.awadhesh.ai.prompt;

import com.awadhesh.ai.dto.interview.InterviewQuestionRequest;
import com.awadhesh.ai.enums.Difficulty;
import com.awadhesh.ai.prompt.interview.InterviewQuestionPromptBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterviewQuestionPromptBuilderTest {

    private final InterviewQuestionPromptBuilder interviewQuestionPromptBuilder
             =  new InterviewQuestionPromptBuilder();
    @Test
    public void shouldBuildInterviewQuestionPromptSuccessfully(){


        InterviewQuestionRequest interviewQuestionRequest = new InterviewQuestionRequest(
                "Senior Java Backend Developer",
                10,
                "Spring Boot",
                Difficulty.HARD,
                5
        );

        String prompt = interviewQuestionPromptBuilder.buildPrompt(interviewQuestionRequest);

        assertAll(

                () -> assertTrue(prompt.contains("Senior Java Backend Developer")),

                () -> assertTrue(prompt.contains("Spring Boot")),

                () -> assertTrue(prompt.contains("10")),

                () -> assertTrue(prompt.contains("HARD")),

                () -> assertTrue(prompt.contains("Return ONLY valid JSON")),

                () -> assertTrue(prompt.contains("5"))

        );


    }

}
