package com.epam.greenhouse.parsers.sax;

import com.epam.greenhouse.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.UUID;

public class FlowerHandler extends DefaultHandler {
    private ArrayList<Flower> flowerList = new ArrayList<Flower>();
    private Flower flower = null;
    private TagSpace currentTag = null;

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        if(qualifiedName.equals("annual") || (qualifiedName.equals("perennial"))) {
            flower = qualifiedName.equals("annual")? new Annual(): new Perennial();
            int firstAttribute = 0;
            int secondAttribute = 1;
            UUID newUUID = UUID.fromString(attributes.getValue(firstAttribute));
            flower.setId(newUUID);
            flower.setName(attributes.getValue(secondAttribute));
        } else {
            currentTag = TagSpace.valueOf(qualifiedName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        if(qualifiedName.equals("annual") || (qualifiedName.equals("perennial"))) {
            flowerList.add(flower);
            flower = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if(currentTag == null) return;
        switch (currentTag) {
            case SOIL:
                Soil soil = Soil.getSoilByTitle(content);
                flower.setSoil(soil);
                break;
            case COLORFLOWER:
            case COLORLEAVES:
            case AVERAGESIZE:
                setVisualParameters(currentTag, content);
                break;
            case TEMPERATURE:
            case LIGHTING:
            case WATERING:
                setGrowingTips(currentTag, content);
                break;
            case PLANTINGTIME:
                Months month = Months.getMonthByTitle(content);
                ((Annual)flower).setPlantingTime(month);
                break;
            case ROOTTYPE:
                RootSystemType root = RootSystemType.getRootByTitle(content);
                ((Perennial)flower).setRootType(root);
                break;
            case EVERGREEN:
                ((Perennial)flower).setEvergreen(Boolean.parseBoolean(content));
                break;
            //default:
                //currentTag = null;
        }
        currentTag = null;
    }

    private void setVisualParameters(TagSpace parameter, String content) {
        VisualParameters visual = new VisualParameters();
        Color color = Color.getColorByTitle(content);
        switch (currentTag) {
            case COLORFLOWER:
                visual.setColorFlower(color);
                break;
            case COLORLEAVES:
                visual.setColorLeaves(color);
                break;
            case AVERAGESIZE:
                visual.setAverageSize(Integer.parseInt(content));
                break;
        }
        flower.setVisual(visual);
    }

    private void setGrowingTips(TagSpace parameter, String content) {
        GrowingTips growing = new GrowingTips();
        switch (currentTag) {
            case TEMPERATURE:
                growing.setTemperature(content);
            case LIGHTING:
                growing.setLighting(content);
            case WATERING:
                growing.setWatering(content);
        }
        flower.setVisual(new VisualParameters());
    }

    public ArrayList<Flower> getFlowerList() {
        return flowerList;
    }
}
