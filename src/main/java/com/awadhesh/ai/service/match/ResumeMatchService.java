package com.awadhesh.ai.service.match;

import com.awadhesh.ai.dto.match.ResumeMatchRequest;
import com.awadhesh.ai.dto.match.ResumeMatchResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResumeMatchService {

    private final SkillNormalizer skillNormalizer;

    public ResumeMatchService(SkillNormalizer skillNormalizer) {
        this.skillNormalizer = skillNormalizer;
    }

    public ResumeMatchResponse match(ResumeMatchRequest request) {

        Set<String> resumeSkills = normalizeSkills(request.resume().technicalSkills());

        Set<String> mandatorySkills = normalizeSkills(request.jobDescription().mandatorySkills());

        Set<String> preferredSkills = normalizeSkills(request.jobDescription().preferredSkills());

        List<String> matchingMandatorySkills =
                findMatchingMandatorySkills(resumeSkills, mandatorySkills);

        List<String> matchingPreferredSkills =
                findMatchingPreferredSkills(resumeSkills, preferredSkills);

        List<String> missingMandatorySkills =
                findMissingMandatorySkills(resumeSkills, mandatorySkills);

        List<String> missingPreferredSkills =
                findMissingPreferredSkills(resumeSkills, preferredSkills);

        List<String> additionalResumeSkills =
                findAdditionalResumeSkills(
                        resumeSkills,
                        mandatorySkills,
                        preferredSkills);

        int overallMatchPercentage =
                calculateMatchPercentage(
                        matchingMandatorySkills.size(),
                        mandatorySkills.size());

        String hiringRecommendation =
                determineHiringRecommendation(overallMatchPercentage);

        List<String> learningPriority =
                determineLearningPriority(missingMandatorySkills);

        return new ResumeMatchResponse(
                overallMatchPercentage,
                matchingMandatorySkills,
                matchingPreferredSkills,
                missingMandatorySkills,
                missingPreferredSkills,
                additionalResumeSkills,
                learningPriority,
                hiringRecommendation
        );
    }


    private Set<String> normalizeSkills(List<String> skills) {

        if (skills == null || skills.isEmpty()) {
            return Set.of();
        }

        return skills.stream()
                .map(skillNormalizer::normalize)
                .collect(Collectors.toSet());
    }


    private List<String> findMatchingMandatorySkills(
            Set<String> resumeSkills,
            Set<String> mandatorySkills) {

        return mandatorySkills.stream()
                .filter(resumeSkills::contains)
                .sorted()
                .toList();
    }

    private List<String> findMissingMandatorySkills(
            Set<String> resumeSkills,
            Set<String> mandatorySkills) {

        return mandatorySkills.stream()
                .filter(skill -> !resumeSkills.contains(skill))
                .sorted()
                .toList();
    }


    private List<String> findMatchingPreferredSkills(
            Set<String> resumeSkills,
            Set<String> preferredSkills) {

        return preferredSkills.stream()
                .filter(resumeSkills::contains)
                .sorted()
                .toList();

    }

    private List<String> findMissingPreferredSkills(
            Set<String> resumeSkills,
            Set<String> preferredSkills) {

        return preferredSkills.stream()
                .filter(skill -> !resumeSkills.contains(skill))
                .sorted()
                .toList();

    }

    private List<String> determineLearningPriority(
            List<String> missingMandatorySkills) {

        return missingMandatorySkills;
    }

    private String determineHiringRecommendation(int percentage) {

        if (percentage >= 90) {
            return "Excellent Match";
        }

        if (percentage >= 75) {
            return "Strong Match";
        }

        if (percentage >= 60) {
            return "Moderate Match";
        }

        return "Needs Significant Improvement";
    }

    private int calculateMatchPercentage(
            int matchedMandatory,
            int totalMandatory) {

        if (totalMandatory == 0) {
            return 0;
        }

        return Math.round((matchedMandatory * 100f) / totalMandatory);
    }

    private List<String> findAdditionalResumeSkills(
            Set<String> resumeSkills,
            Set<String> mandatorySkills,
            Set<String> preferredSkills) {

        return resumeSkills.stream()
                .filter(skill -> !mandatorySkills.contains(skill))
                .filter(skill -> !preferredSkills.contains(skill))
                .sorted()
                .toList();
    }
}


