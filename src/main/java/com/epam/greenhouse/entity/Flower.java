package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Annual.class, Perennial.class})
public class Flower {

    @XmlAttribute(required = true)
    private UUID id;
    @XmlAttribute(required = true)
    private String name;
    @XmlElement
    private Soil soil;
    @XmlElement
    private VisualParameters visual;
    @XmlElement
    private GrowingTips growing;

    public Flower() {
    }

    public Flower(UUID id, String name, Soil soil, VisualParameters visual, GrowingTips growing) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.visual = visual;
        this.growing = growing;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Soil getSoil() {
        return soil;
    }

    public VisualParameters getVisual() {
        return visual;
    }

    public GrowingTips getGrowing() {
        return growing;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public void setVisual(VisualParameters visual) {
        this.visual = visual;
    }

    public void setGrowing(GrowingTips growing) {
        this.growing = growing;
    }
}
