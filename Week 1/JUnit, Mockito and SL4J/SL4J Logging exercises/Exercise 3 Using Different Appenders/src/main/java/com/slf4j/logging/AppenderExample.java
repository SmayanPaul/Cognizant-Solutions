package com.slf4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message for console and file appenders");
        logger.info("Info message for console and file appenders");
    }
}
