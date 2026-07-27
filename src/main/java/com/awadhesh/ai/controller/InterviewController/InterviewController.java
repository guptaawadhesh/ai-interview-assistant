package com.awadhesh.ai.controller.InterviewController;

import com.awadhesh.ai.dto.interview.InterviewQuestionRequest;
import com.awadhesh.ai.dto.interview.InterviewQuestionResponse;
import com.awadhesh.ai.service.interview.InterviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/interview")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {

        this.interviewService = interviewService;
    }

    @PostMapping("/questions")
    public InterviewQuestionResponse generateQuestions(
            @Valid @RequestBody InterviewQuestionRequest request) {

        return interviewService.generateQuestions(request);
    }
}