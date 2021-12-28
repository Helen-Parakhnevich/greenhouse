package com.epam.greenhouse.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HandledException extends Exception {

    private final Logger LOGGER = LogManager.getLogger(HandledException.class);

    public HandledException() {
    }

    public HandledException(String message) {
        LOGGER.warn(message);
    }

    public HandledException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message);
    }

    public void warning(String message, Throwable cause) {
        LOGGER.warn(message);
    }

    public void fatalError(String message, Throwable cause) {
        LOGGER.fatal(message);
    }
}
