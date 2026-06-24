package com.slf4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Alice";
        int loginAttempts = 3;
        logger.info("User {} failed to log in after {} attempts.", username, loginAttempts);
    }
}
