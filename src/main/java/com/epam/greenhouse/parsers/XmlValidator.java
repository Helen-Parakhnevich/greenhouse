package com.epam.greenhouse.parsers;

import com.epam.greenhouse.service.HandledException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlValidator {

    public boolean isValidSax(String fileXML, String fileXSD) throws HandledException {

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(fileXSD));
            Validator validator = schema.newValidator();
            validator.validate(new SAXSource(new InputSource(new FileReader(fileXML))));
            return true;
        } catch (SAXException e) {
            new HandledException(e.getMessage());
            return false;
        } catch (IOException e) {
            new HandledException(e.getMessage());
            return false;
        }
    }

}
