package com.awadhesh.ai.dto.jd;

import java.util.List;

public record JDReviewResponse(

        String detectedRole,

        String jobSummary,

        String seniorityLevel,

        Integer minimumExperience,

        Integer maximumExperience,

        String employmentType,

        String domain,

        List<String> mandatorySkills,

        List<String> preferredSkills,

        List<String> hiringPrioritySkills,

        List<String> responsibilities,

        List<String> interviewTopics,

        Integer estimatedInterviewRounds,

        List<String> marketExpectedSkills,

        List<String> recommendations

) {
}