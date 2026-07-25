package com.awadhesh.ai.dto.interview;

import com.awadhesh.ai.dto.interview.InterviewQuestion;

import java.util.List;

public record InterviewQuestionResponse(

        List<InterviewQuestion> questions

) {
}