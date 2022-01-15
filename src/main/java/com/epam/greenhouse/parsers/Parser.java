package com.epam.greenhouse.parsers;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.service.HandledException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Parser {
    List<Flower> parse(String path) throws HandledException, ParserConfigurationException, IOException, SAXException, JAXBException;
}
