package com.awadhesh.ai.controller.jd;

import com.awadhesh.ai.dto.jd.JDReviewRequest;
import com.awadhesh.ai.dto.jd.JDReviewResponse;
import com.awadhesh.ai.service.jd.JDService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jd")
public class JDController {

private final JDService jdService;

    public JDController(JDService jdService) {
        this.jdService = jdService;
    }

    @PostMapping("/review")
    public JDReviewResponse reviewJobDescription(@Valid @RequestBody JDReviewRequest jdReviewRequest) throws JsonProcessingException {

        return jdService.reviewJobDescription(jdReviewRequest);

    }


}
