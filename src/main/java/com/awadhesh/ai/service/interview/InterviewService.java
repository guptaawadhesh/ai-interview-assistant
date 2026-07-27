package com.awadhesh.ai.service.interview;

import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.interview.InterviewQuestionRequest;
import com.awadhesh.ai.dto.interview.InterviewQuestionResponse;
import com.awadhesh.ai.parser.interview.InterviewQuestionParser;
import com.awadhesh.ai.prompt.interview.InterviewQuestionPromptBuilder;
import com.awadhesh.ai.service.AIOrchestrator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class InterviewService {

    private final AIOrchestrator aiOrchestrator;
    private final InterviewQuestionPromptBuilder promptBuilder;
    private final InterviewQuestionParser parser;
    private static final Logger logger =
            LoggerFactory.getLogger(InterviewService.class);

    public InterviewService(
            AIOrchestrator aiOrchestrator,
            InterviewQuestionPromptBuilder promptBuilder, ObjectMapper objectMapper, InterviewQuestionParser parser) {

        this.aiOrchestrator = aiOrchestrator;
        this.promptBuilder = promptBuilder;
        this.parser = parser;
    }

    public InterviewQuestionResponse generateQuestions(
            InterviewQuestionRequest request) {

        String prompt = promptBuilder.buildPrompt(request);

        AskRequest askRequest = new AskRequest(prompt);

        AIResponse aiResponse = aiOrchestrator.ask(askRequest);

        logger.info("Gemini Response:\n{}", aiResponse.answer());

        return parser.parse(aiResponse.answer());
    }

}
