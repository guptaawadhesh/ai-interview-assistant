package com.awadhesh.ai.exception;

public class AIResponseParsingException
        extends RuntimeException {

    public AIResponseParsingException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}