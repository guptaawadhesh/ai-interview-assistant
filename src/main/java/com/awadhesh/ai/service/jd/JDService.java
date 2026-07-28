package com.awadhesh.ai.service.jd;

import com.awadhesh.ai.dto.AIResponse;
import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.jd.JDReviewRequest;
import com.awadhesh.ai.dto.jd.JDReviewResponse;
import com.awadhesh.ai.parser.jd.JDParser;
import com.awadhesh.ai.prompt.jd.JDPromptBuilder;
import com.awadhesh.ai.service.AIOrchestrator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class JDService {

    private final AIOrchestrator aiOrchestrator;
    private final JDPromptBuilder jdPromptBuilder;
    private final JDParser jdParser;

    public JDService(AIOrchestrator aiOrchestrator, JDPromptBuilder jdPromptBuilder, JDParser jdParser) {
        this.aiOrchestrator = aiOrchestrator;
        this.jdPromptBuilder = jdPromptBuilder;
        this.jdParser = jdParser;
    }

    public JDReviewResponse reviewJobDescription(JDReviewRequest request) throws JsonProcessingException {

        String prompt = jdPromptBuilder.buildPrompt(request);

        AskRequest askRequest = new AskRequest(prompt);

        AIResponse aiResponse =
                aiOrchestrator.ask(askRequest);

        return jdParser.parse(aiResponse.answer());
    }

}
