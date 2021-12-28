package com.epam.greenhouse.core;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.parsers.XmlValidator;
import com.epam.greenhouse.service.HandledException;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final Parser parser;
    private final XmlValidator validator;

    public Director(Parser parser, XmlValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public List<Flower> parse(String xmlFile, String xsdFile) throws HandledException{
        List<Flower> flowerList = new ArrayList<>();
        if (validator.isValidSAX(xmlFile, xsdFile)) {
            flowerList = parser.parse(xmlFile);
        }
        return flowerList;
    }
}
