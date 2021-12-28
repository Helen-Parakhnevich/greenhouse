package com.epam.greenhouse.parsers.jaxb;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.entity.Greenhouse;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.service.HandledException;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {

    @Override
    public List<Flower> parse(String path) throws HandledException {

        List<Flower> flowerList = new ArrayList<Flower>();

        try {
            JAXBContext context = JAXBContext.newInstance(Greenhouse.class);
            Unmarshaller unmarhsaller = context.createUnmarshaller();
            Greenhouse listFlowers = (Greenhouse) unmarhsaller.unmarshal(new InputSource(new FileReader(path)));
            flowerList = listFlowers.getFlowers();
        } catch (JAXBException e) {
            new HandledException(path + " JAXB error: " + e.getMessage(), e);
        } catch (IOException e) {
            new HandledException("I/O error: " + e.getMessage());
        }
        return flowerList;
    }

}
