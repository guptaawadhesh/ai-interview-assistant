package com.awadhesh.ai.prompt.resume;

import com.awadhesh.ai.dto.resume.ResumeReviewRequest;
import com.awadhesh.ai.service.PromptBuilder;
import org.springframework.stereotype.Component;

@Component
public class ResumePromptBuilder implements PromptBuilder<ResumeReviewRequest> {

    @Override
    public String buildPrompt(ResumeReviewRequest request) {

        return """
                You are an expert Senior Technical Recruiter, ATS evaluator, Engineering Hiring Manager,
                and Career Coach with extensive experience hiring software engineers.
                
                Analyze the following resume.
                
                Your analysis must be based on:
                - The candidate's years of professional experience.
                - The candidate's seniority level.
                - The candidate's primary technical profile.
                - Current software engineering hiring standards.
                - Current ATS best practices.
                - Current industry expectations for candidates with similar
                  role, experience, seniority and today's software engineering market.
                
                Your tasks are:
                
                1. Identify the candidate's primary role.
                2. Estimate the candidate's years of professional experience.
                3. Evaluate the resume against current market expectations for that profile.
                4. Assign an ATS score between 0 and 100.
                5. Write a concise overall summary.
                6. List the resume's strengths.
                7. List the resume's weaknesses.
                8. Extract ONLY the technical skills explicitly mentioned in the resume.
                   Do NOT infer or invent skills.
                9. Identify the important technical skills, tools, frameworks, cloud technologies,
                    and engineering practices currently expected in the market for candidates
                    with this profile and experience but not explicitly mentioned in the resume.
                
                10. Provide practical and actionable recommendations...
                
                Return ONLY valid JSON in the following format:
                
                    {
                      "detectedRole": "",
                      "experienceYears": 0,
                      "atsScore": 0,
                      "overallSummary": "",
                      "strengths": [],
                      "weaknesses": [],
                      "technicalSkills": [],
                      "marketExpectedSkills": [],
                      "recommendations": []
                    }
                
                Rules:
                
                - Return ONLY the JSON object.
                - Do NOT return markdown.
                - Do NOT use ```json.
                - Do NOT add explanations or introductory text.
                - ATS score must be an integer between 0 and 100.
                - Experience years must be an integer.
                - Extract only skills explicitly present in the resume.
                - Never invent technologies or experience.
                - If any field has no data, return an empty string or empty array.
                - Never return null.
                - Evaluate the resume against candidates with similar experience and profile.
                - Do NOT compare the resume with entry-level candidates.
                - Recommendations should focus on helping the candidate become highly competitive in today's software engineering job market.
                - Base your evaluation only on the information present in the resume.
                  Do not assume achievements, leadership experience, technologies,
                  or responsibilities that are not explicitly mentioned.
                - Recommendations should prioritize changes that would increase
                  the candidate's chances of getting shortlisted and succeeding
                  in technical interviews.
                
                Resume:
                
                %s
                """
                .formatted(request.resume());


    }
}
