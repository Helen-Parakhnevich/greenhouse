package com.epam.greenhouse.parsers.sax;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.service.HandledException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parser {
    ArrayList<Flower> flowerList = new ArrayList<Flower>();

    @Override
    public List<Flower> parse(String path) throws HandledException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        FlowerHandler contentHandler = new FlowerHandler();

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            saxParser.parse(path, contentHandler);
        } catch (ParserConfigurationException |SAXException| IOException e) {
            throw new HandledException(e.getMessage());
        }
        return contentHandler.getFlowerList();
    }
}
