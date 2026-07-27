package com.awadhesh.ai.prompt.resume.rewrite;

import com.awadhesh.ai.dto.resume.rewrite.ResumeRewriteRequest;
import com.awadhesh.ai.service.PromptBuilder;
import org.springframework.stereotype.Component;

@Component
public class ResumeRewritePromptBuilder implements PromptBuilder<ResumeRewriteRequest> {


    @Override
    public String buildPrompt(ResumeRewriteRequest request) {

        return """
        You are an expert Executive Resume Writer, Senior Technical Recruiter,
        Engineering Hiring Manager, ATS Optimization Specialist, and Career Coach.

        Rewrite the following software engineering resume to make it highly competitive
        for today's software engineering job market.

        Your objective is to maximize interview opportunities while remaining
        completely truthful.

        The rewritten resume should meet or exceed current market expectations
        for software engineers with similar years of experience, seniority,
        and technical profile.

        Your rewriting must follow these principles:

        1. Preserve every factual detail.
        2. Never invent companies.
        3. Never invent job titles.
        4. Never invent technologies.
        5. Never invent certifications.
        6. Never invent achievements.
        7. Never invent metrics or numbers.
        8. Never exaggerate responsibilities.
        9. Never change employment dates.
        10. Never change project names.
        11. Never remove any factual technical skill from the resume.
        12. Only reorganize and improve presentation.

        Improve the resume by:

        - Making every bullet point stronger and more impactful.
        - Using modern action verbs.
        - Improving readability.
        - Improving ATS keyword optimization.
        - Improving grammar and professionalism.
        - Highlighting leadership and ownership wherever supported.
        - Highlighting architectural thinking wherever supported.
        - Highlighting business impact wherever supported.
        - Removing repetitive wording.
        - Improving technical presentation.
        - Organizing skills using current industry standards.
        - Preserving all technical depth while improving clarity.
        - Preserving important business domain experience such as Banking,
          Financial Services, Payments, Fraud Detection,
          Transaction Monitoring, Clearing & Settlement,
          and Regulatory Compliance.
        - Making the resume suitable for Senior Java Backend Engineer,
          Senior Software Engineer,
          Lead Engineer,
          Staff Engineer,
          and Engineering Manager interviews.

        If measurable impact is missing,
        DO NOT invent numbers.

        Instead rewrite the sentence so it sounds stronger while remaining truthful.

        Do NOT optimize the resume for a specific company
        or job description.

        Rewrite it as a strong,
        general-purpose,
        market-ready resume suitable for senior Java backend roles.

        Job-description-specific optimization
        will be handled separately.

        Return ONLY valid JSON in the following format:

        {
          "rewrittenResume": "",
          "summaryOfChanges": "",
          "estimatedATSScore": 0,
          "improvements": []
        }

        Rules:

        - Return ONLY the JSON object.
        - Do NOT return markdown.
        - Do NOT use ```json.
        - Do NOT explain your answer.
        - Do NOT include any additional text.
        - Never return null.
        - Preserve all factual information.
        - Produce a polished, ATS-optimized,
          professional resume that could be confidently submitted
          for Senior Java Backend Engineer,
          Lead Engineer,
          Staff Engineer,
          or Engineering Manager interviews.

        Resume:

        %s
        """
                .formatted(request.resume());

    }

}
