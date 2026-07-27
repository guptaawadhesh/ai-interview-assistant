package com.awadhesh.ai.service.resume;

import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.resume.ResumeReviewRequest;
import com.awadhesh.ai.dto.resume.ResumeReviewResponse;
import com.awadhesh.ai.parser.resume.ResumeParser;
import com.awadhesh.ai.prompt.resume.ResumePromptBuilder;
import com.awadhesh.ai.service.AIOrchestrator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private final AIOrchestrator aiOrchestrator;
    private final ResumePromptBuilder promptBuilder;
    private final ResumeParser resumeParser;

    public ResumeService(AIOrchestrator aiOrchestrator,
                         ResumePromptBuilder promptBuilder,
                         ResumeParser resumeParser) {
        this.aiOrchestrator = aiOrchestrator;
        this.promptBuilder = promptBuilder;
        this.resumeParser = resumeParser;
    }

    public ResumeReviewResponse reviewResume(ResumeReviewRequest request) throws JsonProcessingException {

        String prompt = promptBuilder.buildPrompt(request);

        AskRequest askRequest = new AskRequest(prompt);

        AIResponse aiResponse =
                aiOrchestrator.ask(askRequest);

        return resumeParser.parse(aiResponse.answer());
    }

}
