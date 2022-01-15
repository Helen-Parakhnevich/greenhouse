package com.epam.greenhouse.core;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.parsers.XmlValidator;
import com.epam.greenhouse.service.HandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {

    private final Parser parser;
    private final XmlValidator validator;
    private final Logger LOGGER = LogManager.getLogger(Director.class);

    public Director(Parser parser, XmlValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public List<Flower> parse(String xmlFile, String xsdFile) throws HandledException {
        List<Flower> flowerList = new ArrayList<>();
        try {
            if (validator.isValidSax(xmlFile, xsdFile)) {
                flowerList = parser.parse(xmlFile);
            }
            return flowerList;
        } catch (SAXException | JAXBException| IOException | ParserConfigurationException e) {
            LOGGER.error(e.getMessage(), e);
            throw new HandledException(e.getMessage(), e);
        }
    }
}
