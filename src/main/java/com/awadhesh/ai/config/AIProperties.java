package com.awadhesh.ai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai")
public record AIProperties (String defaultProvider) {


}
