package com.awadhesh.ai.controller;

import com.awadhesh.ai.dto.AskRequest;
import com.awadhesh.ai.dto.AskResponse;
import com.awadhesh.ai.dto.OllamaResponse;
import com.awadhesh.ai.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
public class AIController {

    private final AIService aiService;
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask")
    public AskResponse ask(@RequestBody AskRequest askRequest) {
        OllamaResponse ollamaResponse = aiService.ask(askRequest.prompt());

        return new AskResponse(ollamaResponse.response());
    }

}
