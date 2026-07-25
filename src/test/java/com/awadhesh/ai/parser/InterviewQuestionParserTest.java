package com.awadhesh.ai.parser;

import com.awadhesh.ai.dto.interview.InterviewQuestionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InterviewQuestionParserTest {

    @Test
    void shouldParseInterviewQuestionResponse() {

        ObjectMapper mapper = new ObjectMapper();

        InterviewQuestionParser parser =
                new InterviewQuestionParser(mapper);

        String json = """
{
  "questions": [
    {
      "number": 1,
      "question": "What is Spring Boot?"
    }
  ]
}
""";

        InterviewQuestionResponse response = parser.parse(json);

        assertAll(
                () -> assertEquals(1, response.questions().size()),
                () -> assertEquals(1, response.questions().getFirst().number()),
                () -> assertEquals(
                        "What is Spring Boot?",
                        response.questions().getFirst().question()
                )
        );



    }
}
