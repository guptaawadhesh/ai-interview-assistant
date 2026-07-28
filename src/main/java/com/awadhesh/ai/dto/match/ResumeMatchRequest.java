package com.awadhesh.ai.dto.match;

import com.awadhesh.ai.dto.jd.JDReviewResponse;
import com.awadhesh.ai.dto.resume.ResumeReviewResponse;

public record ResumeMatchRequest(

        ResumeReviewResponse resume,

        JDReviewResponse jobDescription

) {
}