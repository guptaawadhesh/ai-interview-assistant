package com.awadhesh.ai.service;

public interface PromptBuilder<T> {

    String buildPrompt(T request);

}