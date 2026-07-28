package com.awadhesh.ai.prompt.jd;

import com.awadhesh.ai.dto.jd.JDReviewRequest;
import com.awadhesh.ai.service.PromptBuilder;
import org.springframework.stereotype.Component;

@Component
public class JDPromptBuilder implements PromptBuilder<JDReviewRequest> {

    @Override
    public String buildPrompt(JDReviewRequest request) {

        return """
                You are an expert Senior Technical Recruiter, Engineering Hiring Manager,
                Technical Interviewer, and Career Coach with extensive experience hiring
                software engineers across startups, product companies, and large enterprises.
                
                Analyze the following Job Description (JD).
                
                Your analysis must be based ONLY on the information explicitly provided in the JD,
                while also applying current software engineering hiring standards and market expectations.
                
                Your tasks are:
                
                1. Identify the primary job role.
                2. Write a concise summary of the role.
                3. Determine the expected seniority level
                   (Intern, Junior, Mid-Level, Senior, Lead, Staff, Principal, Architect, Manager).
                4. Extract the minimum and maximum years of experience required.
                   If only one value is mentioned, use it as the minimum and leave maximum as 0.
                5. Identify the employment type
                   (Full-time, Contract, Internship, Hybrid, Remote, Onsite, Unknown).
                6. Identify the business domain
                   (Banking, Payments, Healthcare, Retail, Manufacturing, FinTech, etc.).
                7. Extract ONLY the mandatory technical skills explicitly mentioned.
                8. Extract ONLY the preferred or nice-to-have skills explicitly mentioned.
                9. Identify the top hiring priority skills based on the overall JD.
                10. Extract the primary responsibilities.
                11. Predict the most likely interview topics based on the role and required skills.
                12. Estimate the likely number of interview rounds for this type of role.
                13. Suggest additional market-expected skills that are commonly expected
                    for candidates applying to similar roles today, even if they are not
                    explicitly mentioned in the JD.
                    Do NOT include these in mandatorySkills.
                14. Provide practical recommendations for a candidate preparing
                    for this position.
                
                Return ONLY valid JSON in the following format:
                
                {
                  "detectedRole": "",
                  "jobSummary": "",
                  "seniorityLevel": "",
                  "minimumExperience": 0,
                  "maximumExperience": 0,
                  "employmentType": "",
                  "domain": "",
                  "mandatorySkills": [],
                  "preferredSkills": [],
                  "hiringPrioritySkills": [],
                  "responsibilities": [],
                  "interviewTopics": [],
                  "estimatedInterviewRounds": 0,
                  "marketExpectedSkills": [],
                  "recommendations": []
                }
                
                Rules:
                
                - Return ONLY the JSON object.
                - Do NOT return markdown.
                - Do NOT use ```json.
                - Do NOT explain your answer.
                - Do NOT include any additional text.
                - Never return null.
                - If information is unavailable, return an empty string, 0, or an empty array.
                - Extract mandatorySkills and preferredSkills ONLY from the JD.
                - Never invent technologies or requirements that are not present in the JD.
                - marketExpectedSkills may include additional industry-standard skills
                  that are commonly expected for similar roles.
                - Recommendations should be practical, prioritized, and actionable.
                - Interview topics should focus on the technologies, architecture,
                  problem-solving, and domain knowledge most likely to be assessed.
                
                Job Description:
                
                %s
                """
                .formatted(request.jobDescription());

    }

}
