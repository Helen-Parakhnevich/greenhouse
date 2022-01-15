package com.epam.greenhouse.parsers.jaxb;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.entity.Greenhouse;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.service.HandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {

    private final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    @Override
    public List<Flower> parse(String path) throws IOException,JAXBException{

        try {
            JAXBContext context = JAXBContext.newInstance(Greenhouse.class);
            Unmarshaller unmarhsaller = context.createUnmarshaller();
            FileReader reader = new FileReader(path);
            InputSource inputSource = new InputSource(reader);
            Greenhouse listFlowers = (Greenhouse) unmarhsaller.unmarshal(inputSource);
            return listFlowers.getFlowers();
        } catch (JAXBException e) {
            LOGGER.error(e);
            throw e;
        } catch (IOException e) {
            LOGGER.error(e);
            throw e;
        }
    }

}
