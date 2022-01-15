package com.epam.greenhouse.parsers.jaxb;

import com.epam.greenhouse.entity.*;
import com.epam.greenhouse.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JaxbParserTest {

    private final static String FILE_XML = "src/test/resources/flowers.xml";
    private static List<Flower> EXPECTED_FLOWERS = Arrays.asList(
            new Annual(UUID.fromString("abaa2a-faa8-4f55-bf51-d812411e571f"), "aster",
                    Soil.PODZOLIC, new VisualParameters(Color.RED, Color.GREEN,40),
                    new GrowingTips("10-30C", "800FC", "medium"), Months.APRIL),
            new Perennial(UUID.fromString("fb774a46-3c49-4174-b562-3dbd36671cc3"), "peony",
                    Soil.LAND_BASED, new VisualParameters(Color.PINK, Color.GREEN,100),
                    new GrowingTips("0-35C", "600FC", "medium"),
                    RootSystemType.FIBROUS, false));

    @Test
    public void testJabParserWhenFileValid() throws IOException,JAXBException {
        //given
        JaxbParser jaxbParser = new JaxbParser();

        //when
        List<Flower> result = jaxbParser.parse(FILE_XML);

        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(EXPECTED_FLOWERS, result);
    }

    @Test
    public void marshalling() throws JAXBException {
        //given
        VisualParameters paramsAnnual = new VisualParameters(Color.RED, Color.GREEN,10);
        VisualParameters paramsPerennial = new VisualParameters(Color.YELLOW, Color.VIOLET,15);
        GrowingTips tipsAnnual = new GrowingTips("20", "10", "be careful");
        GrowingTips tipsPerennial = new GrowingTips("25", "15", "be careful also");

        Annual annual = new Annual(UUID.randomUUID(), "test annual", Soil.LAND_BASED,
                paramsAnnual, tipsAnnual, Months.AUGUST);
        Perennial perennial = new Perennial(UUID.randomUUID(), "test perennial", Soil.PODZOLIC,
                paramsPerennial, tipsPerennial,RootSystemType.BULB, true);

        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setFlowers(Arrays.asList(annual, perennial));
        //when
        JAXBContext context = JAXBContext.newInstance(Greenhouse.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.com/flowers flowers.xsd");
        marshaller.marshal(greenhouse, new File("src/test/resources/out.xml"));
        //then
    }
}
