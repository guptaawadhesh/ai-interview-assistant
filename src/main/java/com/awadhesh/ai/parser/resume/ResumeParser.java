package com.awadhesh.ai.parser.resume;

import com.awadhesh.ai.dto.resume.ResumeReviewRequest;
import com.awadhesh.ai.dto.resume.ResumeReviewResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ResumeParser {

    private final ObjectMapper objectMapper;

    public ResumeParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResumeReviewResponse parse(String json) throws JsonProcessingException {

        return objectMapper.readValue(json, ResumeReviewResponse.class);

    }

}
