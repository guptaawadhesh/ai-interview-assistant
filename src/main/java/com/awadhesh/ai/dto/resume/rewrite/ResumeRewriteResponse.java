package com.awadhesh.ai.dto.resume.rewrite;

import java.util.List;

public record ResumeRewriteResponse(

        String rewrittenResume,

        List<String> improvements

) {
}

