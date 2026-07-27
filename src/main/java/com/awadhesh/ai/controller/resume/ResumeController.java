package com.awadhesh.ai.controller.resume;

import com.awadhesh.ai.dto.resume.ResumeReviewRequest;
import com.awadhesh.ai.dto.resume.ResumeReviewResponse;
import com.awadhesh.ai.service.resume.ResumeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/review")
    public ResumeReviewResponse reviewResume(@Valid @RequestBody ResumeReviewRequest request)
            throws JsonProcessingException {

        return resumeService.reviewResume(request);

    }

}
