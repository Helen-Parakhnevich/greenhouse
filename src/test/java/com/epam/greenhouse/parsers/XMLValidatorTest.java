package com.epam.greenhouse.parsers;

import com.epam.greenhouse.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

public class XMLValidatorTest {

    private final static String FILE_XML = "src/test/resources/flowers.xml";
    private final static String FILE_XSD = "src/test/resources/flowers.xsd";

    @Test
    public void testisValidSAXWhenFilesExists() throws HandledException {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        String fileXML = "src/test/resources/flowers.xml";
        String fileXSD = "src/test/resources/flowers.xsd";

        //when
        boolean result = xmlValidator.isValidSAX(FILE_XML, FILE_XSD);

        //then
        Assert.assertTrue(result);
    }
}
