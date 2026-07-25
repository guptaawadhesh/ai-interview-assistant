package com.awadhesh.ai.prompt;

import com.awadhesh.ai.dto.interview.InterviewQuestionRequest;
import com.awadhesh.ai.service.PromptBuilder;
import org.springframework.stereotype.Component;

@Component
public class InterviewQuestionPromptBuilder
        implements PromptBuilder<InterviewQuestionRequest> {

    public String buildPrompt(InterviewQuestionRequest request) {

        return """
Generate %d interview questions for the following candidate.

Role: %s
Experience: %d years
Topic: %s
Difficulty: %s

Return ONLY valid JSON in the following format.

{
  "questions": [
    {
      "number": 1,
      "question": "Question text"
    }
  ]
}

Rules:
- Return exactly %d questions.
- Do not return markdown.
- Do not use ```json.
- Do not add explanations.
- Do not add introductory text.
- Return ONLY the JSON object.
"""
                .formatted(
                        request.count(),
                        request.role(),
                        request.experience(),
                        request.topic(),
                        request.difficulty(),
                        request.count()
                );
    }


}