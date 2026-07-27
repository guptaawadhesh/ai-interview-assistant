package com.awadhesh.ai.dto.resume;

import java.util.List;

public record ResumeReviewResponse(

        String detectedRole,

        Integer experienceYears,

        Integer atsScore,

        String overallSummary,

        List<String> strengths,

        List<String> weaknesses,

        List<String> technicalSkills,

        List<String> marketExpectedSkills,

        List<String> recommendations

) {
}