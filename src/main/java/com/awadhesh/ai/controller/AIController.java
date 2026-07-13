package com.awadhesh.ai.controller;

import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.AskResponse;
import com.awadhesh.ai.service.AIService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
public class AIController {

    private static final Logger logger = LoggerFactory.getLogger(AIController.class);
    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask")
    public AskResponse ask(@Valid @RequestBody AskRequest request) {

        logger.info("Received AI request. Prompt: {}", request.prompt());

        String answer = aiService.ask(request.prompt());

        logger.info("AI response generated successfully.");

        return new AskResponse(answer);
    }
}