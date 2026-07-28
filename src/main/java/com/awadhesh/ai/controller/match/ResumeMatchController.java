package com.awadhesh.ai.controller.match;

import com.awadhesh.ai.dto.match.ResumeMatchRequest;
import com.awadhesh.ai.dto.match.ResumeMatchResponse;
import com.awadhesh.ai.service.match.ResumeMatchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/match")
public class ResumeMatchController {

    private final ResumeMatchService resumeMatchService;

    public ResumeMatchController(ResumeMatchService resumeMatchService) {
        this.resumeMatchService = resumeMatchService;
    }

    @PostMapping
    public ResumeMatchResponse match(
            @Valid @RequestBody ResumeMatchRequest request) {

        return resumeMatchService.match(request);
    }
}