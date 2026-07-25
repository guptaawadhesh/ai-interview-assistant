package com.awadhesh.ai.service;

import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.interview.InterviewQuestionRequest;
import com.awadhesh.ai.dto.interview.InterviewQuestionResponse;
import com.awadhesh.ai.enums.Difficulty;
import com.awadhesh.ai.parser.InterviewQuestionParser;
import com.awadhesh.ai.prompt.InterviewQuestionPromptBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InterviewServiceTest {

    @Mock
    private AIOrchestrator aiOrchestrator;

    @Mock
    private InterviewQuestionPromptBuilder promptBuilder;

    @Mock
    private InterviewQuestionParser parser;

    @InjectMocks
    private InterviewService interviewService;

    @Test
    void shouldGenerateQuestions() {

        InterviewQuestionRequest request =
                new InterviewQuestionRequest(
                        "Senior Java Backend Developer",
                        10,
                        "Spring Boot",
                        Difficulty.HARD,
                        5
                );

        String prompt = "Generate questions";

        AIResponse aiResponse =
                new AIResponse(
                        "{\"questions\":[]}",
                        "gemini",
                        "gemini-3.6-flash"
                );

        InterviewQuestionResponse expected =
                new InterviewQuestionResponse(
                        java.util.List.of()
                );

        when(promptBuilder.buildPrompt(any()))
                .thenReturn(prompt);

        when(aiOrchestrator.ask(any(AskRequest.class)))
                .thenReturn(aiResponse);

        when(parser.parse(any()))
                .thenReturn(expected);

        InterviewQuestionResponse actual =
                interviewService.generateQuestions(request);

        assertEquals(expected, actual);

        verify(promptBuilder).buildPrompt(any());

        verify(aiOrchestrator).ask(any(AskRequest.class));

        verify(parser).parse(any());
    }
}