package com.awadhesh.ai.parser.interview;

import com.awadhesh.ai.dto.interview.InterviewQuestionResponse;
import com.awadhesh.ai.exception.AIResponseParsingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class InterviewQuestionParser {

    private final ObjectMapper objectMapper;

    public InterviewQuestionParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public InterviewQuestionResponse parse(String json) {

        try {

            return objectMapper.readValue(
                    json,
                    InterviewQuestionResponse.class);

        } catch (JsonProcessingException ex) {

            throw new AIResponseParsingException(
                    "Unable to parse AI response.",
                    ex
            );
        }
    }
}