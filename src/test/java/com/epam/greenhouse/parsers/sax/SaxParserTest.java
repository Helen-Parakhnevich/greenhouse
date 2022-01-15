package com.epam.greenhouse.parsers.sax;

import com.epam.greenhouse.entity.*;
import com.epam.greenhouse.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SaxParserTest {

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
    public void testSaxParserWhenFileValid() throws HandledException {
        //given
        SaxParser saxParser = new SaxParser();

        //when
        List<Flower> result = saxParser.parse(FILE_XML);

        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(EXPECTED_FLOWERS, result);
    }
}
