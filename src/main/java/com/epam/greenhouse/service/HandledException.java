package com.epam.greenhouse.service;

import javax.xml.parsers.ParserConfigurationException;

public class HandledException extends ParserConfigurationException {

    public HandledException() {
    }

    public HandledException(String message) {
        super(message);
    }
}
