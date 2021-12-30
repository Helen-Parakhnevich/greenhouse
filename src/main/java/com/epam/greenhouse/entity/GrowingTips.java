package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "temperature",
        "lighting",
        "watering"
})
public class GrowingTips {
    @XmlElement(required = true)
    private String temperature;
    @XmlElement(required = true)
    private String lighting;
    @XmlElement(required = true)
    private String watering;

    public GrowingTips() {
    }

    public GrowingTips(String temperature, String lighting, String watering) {
        this.temperature = temperature;
        this.lighting = lighting;
        this.watering = watering;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }
}
