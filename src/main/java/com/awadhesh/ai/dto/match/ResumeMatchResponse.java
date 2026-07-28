package com.awadhesh.ai.dto.match;

import java.util.List;

public record ResumeMatchResponse(

        Integer overallMatchPercentage,

        List<String> matchingMandatorySkills,

        List<String> matchingPreferredSkills,

        List<String> missingMandatorySkills,

        List<String> missingPreferredSkills,

        List<String> additionalResumeSkills,

        List<String> learningPriority,

        String hiringRecommendation

) {
}