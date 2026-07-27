package com.awadhesh.ai.service.resume.rewrite;

import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteRequest;
import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteResponse;
import com.awadhesh.ai.parser.resume.rewrite.ResumeRewriteParser;
import com.awadhesh.ai.prompt.resume.rewrite.ResumeRewritePromptBuilder;
import com.awadhesh.ai.service.AIOrchestrator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class ResumeRewriteService {

    private final AIOrchestrator aiOrchestrator;
    private final ResumeRewriteParser resumeRewriteParser;
    private final ResumeRewritePromptBuilder resumeRewritePromptBuilder;


    public ResumeRewriteService(AIOrchestrator aiOrchestrator, ResumeRewriteParser resumeRewriteParser
            , ResumeRewritePromptBuilder resumeRewritePromptBuilder) {
        this.aiOrchestrator = aiOrchestrator;
        this.resumeRewriteParser = resumeRewriteParser;
        this.resumeRewritePromptBuilder = resumeRewritePromptBuilder;
    }

    public ResumeRewriteResponse rewriteResume(ResumeRewriteRequest request) throws JsonProcessingException {

        String prompt = resumeRewritePromptBuilder.buildPrompt(request);

        AskRequest askRequest = new AskRequest(prompt);

        AIResponse aiResponse =
                aiOrchestrator.ask(askRequest);

        return resumeRewriteParser.parse(aiResponse.answer());

    }

}
