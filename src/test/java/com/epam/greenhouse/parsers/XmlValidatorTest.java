package com.epam.greenhouse.parsers;

import com.epam.greenhouse.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    private final static String FILE_XML = "src/test/resources/flowers.xml";
    private final static String FILE_XML_INVALID = "src/test/resources/flowers_invld.xml";
    private final static String FILE_XSD = "src/test/resources/flowers.xsd";

    @Test
    public void testisValidSAXWhenFileValid() throws HandledException {
        //given
        XmlValidator xmlValidator = new XmlValidator();

        //when
        boolean result = xmlValidator.isValidSax(FILE_XML, FILE_XSD);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testisValidSAXWhenFileInvalid() throws HandledException {
        //given
        XmlValidator xmlValidator = new XmlValidator();

        //when
        boolean result = xmlValidator.isValidSax(FILE_XML_INVALID, FILE_XSD);

        //then
        Assert.assertFalse(result);
    }
}
