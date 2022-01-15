package com.epam.greenhouse.parsers.dom;

import com.epam.greenhouse.entity.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class DomAnalyzer {

    public static ArrayList<Flower> listBuilder(Element root) throws SAXException, IOException {

        ArrayList<Flower> flowerCollection = new ArrayList<Flower>();

        NodeList flowerNodes= root.getChildNodes();

        for (int i = 0; i < flowerNodes.getLength(); i++) {
            Node currentNode = flowerNodes.item(i);
            String nameNode = currentNode.getNodeName();
            switch (nameNode){
                case "annual":
                    Annual annual = new Annual();
                    fillFlowerFields((Element)currentNode, annual);
                    fillAnnualFields((Element)currentNode, annual);
                    flowerCollection.add(annual);
                    break;
                case "perennial":
                    Perennial perennial = new Perennial();
                    fillFlowerFields((Element)currentNode, perennial);
                    fillPerennialFields((Element)currentNode, perennial);
                    flowerCollection.add(perennial);
                    break;
            }
        }
        return flowerCollection;
    }

    private static void fillFlowerFields(Element element, Flower flower) {
        UUID id = UUID.fromString(element.getAttribute("id"));
        flower.setId(id);
        flower.setName(element.getAttribute("name"));

        Soil soil = Soil.getSoilByTitle(getBabyValue(element, "soil"));
        flower.setSoil(soil);

        Element visualElement = getBaby(element, "visual");
        if (visualElement!=null) {
            Color colorFlower = Color.getColorByTitle(getBabyValue(visualElement, "colorFlower"));
            Color colorLeaves = Color.getColorByTitle(getBabyValue(visualElement, "colorLeaves"));
            int size = Integer.parseInt(getBabyValue(visualElement, "averageSize"));
            VisualParameters visual = new VisualParameters(colorFlower, colorLeaves, size);
            flower.setVisual(visual);
        }

        Element growingElement = getBaby(element, "growing");
        if (visualElement!=null) {
            String temperature = getBabyValue(growingElement, "temperature");
            String lighting = getBabyValue(growingElement, "lighting");
            String watering = getBabyValue(growingElement, "watering");
            GrowingTips growing = new GrowingTips(temperature, lighting, watering);
            flower.setGrowing(growing);
        }
    }

    private static void fillAnnualFields(Element element, Annual annual) {
        Months month = Months.getMonthByTitle(getBabyValue(element, "plantingTime"));
        annual.setPlantingTime(month);
    }

    private static void fillPerennialFields(Element element, Perennial perennial) {
        Boolean evergreen = Boolean.parseBoolean(getBabyValue(element, "evergreen"));
        perennial.setEvergreen(evergreen);

        RootSystemType rootType = RootSystemType.getRootByTitle(getBabyValue(element, "rootType"));
        perennial.setRootType(rootType);
    }

    private static Element getBaby(Element parent,
                                   String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }

    private static String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        if (child!=null) {
            Node node = child.getFirstChild();
            String value = node.getNodeValue();
            return value;
        } else {
            return "";
        }
    }
}


