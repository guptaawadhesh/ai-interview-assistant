package com.awadhesh.ai.parser.jd;

import com.awadhesh.ai.dto.jd.JDReviewResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JDParser {

    private final ObjectMapper objectMapper;

    public JDParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JDReviewResponse parse(String json) throws JsonProcessingException {

        return objectMapper.readValue(json, JDReviewResponse.class);

    }

}
