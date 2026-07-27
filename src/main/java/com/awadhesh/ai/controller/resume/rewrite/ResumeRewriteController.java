package com.awadhesh.ai.controller.resume.rewrite;

import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteRequest;
import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteResponse;
import com.awadhesh.ai.service.resume.rewrite.ResumeRewriteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeRewriteController {

    private final ResumeRewriteService resumeRewriteService;

    public ResumeRewriteController(ResumeRewriteService resumeRewriteService) {

        this.resumeRewriteService = resumeRewriteService;
    }

    @PostMapping("/rewrite")
    public ResumeRewriteResponse rewriteResume(@Valid @RequestBody ResumeRewriteRequest request) throws JsonProcessingException {

        return resumeRewriteService.rewriteResume(request);

    }

}
