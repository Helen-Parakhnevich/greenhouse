package com.epam.greenhouse.service;

import javax.xml.parsers.ParserConfigurationException;

public class HandledException extends Exception {

    public HandledException() {
    }

    public HandledException(String message) {
        super(message);
    }

    public HandledException(String message, Throwable cause) {
        super(message, cause);
    }
}
