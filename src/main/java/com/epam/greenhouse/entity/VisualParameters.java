package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "colorFlower",
        "colorLeaves",
        "averageSize"
})
public class VisualParameters {
    @XmlElement(required = true)
    private Color colorFlower;
    @XmlElement(required = true)
    private Color colorLeaves;
    @XmlElement(required = true)
    private int averageSize;

    public VisualParameters() {
    }

    public VisualParameters(Color colorFlower, Color colorLeaves, int averageSize) {
        this.colorFlower = colorFlower;
        this.colorLeaves = colorLeaves;
        this.averageSize = averageSize;
    }

    public void setColorFlower(Color colorFlower) {
        this.colorFlower = colorFlower;
    }

    public void setColorLeaves(Color colorLeaves) {
        this.colorLeaves = colorLeaves;
    }

    public void setAverageSize(int averageSize) {
        this.averageSize = averageSize;
    }
}
