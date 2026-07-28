package com.awadhesh.ai.service.match;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Normalizes different representations of the same skill
 * into a single canonical skill.
 *
 * Example:
 * Java (JDK 17+)  -> java
 * RESTful API     -> rest api
 * GitHub          -> git
 *
 * This ensures Resume Match, Gap Analysis, Learning Roadmap,
 * and Interview modules compare skills consistently.
 */
@Component
public class SkillNormalizer {

    /**
     * Dictionary containing all known skill aliases.
     *
     * Key   = Raw skill returned by AI
     * Value = Canonical skill used throughout CareerPilot
     */
    private static final Map<String, String> SKILL_MAP = new HashMap<>();

    static {

        /* =========================
           Java
         ========================= */

        SKILL_MAP.put("java (jdk 17+)", "java");
        SKILL_MAP.put("java (jdk 21+)", "java");
        SKILL_MAP.put("java 17", "java");
        SKILL_MAP.put("java 21", "java");

        /* =========================
           Spring
         ========================= */

        SKILL_MAP.put("spring framework", "spring");
        SKILL_MAP.put("spring boot 2", "spring boot");
        SKILL_MAP.put("spring boot 3", "spring boot");

        /* =========================
           REST APIs
         ========================= */

        SKILL_MAP.put("restful api", "rest api");
        SKILL_MAP.put("restful api design", "rest api");
        SKILL_MAP.put("rest apis", "rest api");
        SKILL_MAP.put("web services", "rest api");

        /* =========================
           Microservices
         ========================= */

        SKILL_MAP.put("microservices architecture", "microservices");

        /* =========================
           Version Control
         ========================= */

        SKILL_MAP.put("github", "git");
        SKILL_MAP.put("gitlab", "git");
        SKILL_MAP.put("bitbucket", "git");

        /* =========================
           Databases
         ========================= */

        SKILL_MAP.put("postgresql", "sql");
        SKILL_MAP.put("mysql", "sql");
        SKILL_MAP.put("oracle", "sql");
        SKILL_MAP.put("sql server", "sql");

        /* =========================
           Security
         ========================= */

        SKILL_MAP.put("oauth2", "oauth");
        SKILL_MAP.put("jwt authentication", "jwt");

        /* =========================
           CI/CD
         ========================= */

        SKILL_MAP.put("ci/cd", "cicd");
        SKILL_MAP.put("ci/cd pipelines", "cicd");
    }

    /**
     * Converts a raw skill into its canonical form.
     *
     * Steps:
     * 1. Handle null or blank values.
     * 2. Trim whitespace.
     * 3. Convert to lowercase.
     * 4. Replace aliases using the dictionary.
     *
     * If no mapping exists, return the cleaned skill.
     *
     * Example:
     * Input : " Java (JDK 17+) "
     * Output: "java"
     */
    public String normalize(String skill) {

        if (skill == null || skill.isBlank()) {
            return "";
        }

        String normalized = skill.trim().toLowerCase();

        return SKILL_MAP.getOrDefault(normalized, normalized);
    }
}