package com.awadhesh.ai.parser.resume.rewrite;

import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ResumeRewriteParser {

    private final ObjectMapper objectMapper;

    public ResumeRewriteParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResumeRewriteResponse parse(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, ResumeRewriteResponse.class);
    }
}
