package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement(name = "perennial")
public class Perennial extends Flower {

    @XmlElement
    private RootSystemType rootType;
    @XmlElement
    private boolean evergreen;

    public Perennial() {
    }

    public Perennial(UUID id, String name, Soil soil, VisualParameters visual, GrowingTips growing, RootSystemType rootType, boolean evergreen) {
        super(id, name, soil, visual, growing);
        this.rootType = rootType;
        this.evergreen = evergreen;
    }

    public void setRootType(RootSystemType rootType) {
        this.rootType = rootType;
    }

    public void setEvergreen(boolean evergreen) {
        this.evergreen = evergreen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Perennial)) {
            return false;
        }
        Perennial perennial = (Perennial) o;
        return evergreen == perennial.evergreen && rootType == perennial.rootType;
    }

    @Override
    public int hashCode() {
        int result = 31*super.hashCode();
        result = 31*result + rootType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Perennial{" +
                "rootType=" + rootType +
                ", evergreen=" + evergreen +
                '}';
    }
}
