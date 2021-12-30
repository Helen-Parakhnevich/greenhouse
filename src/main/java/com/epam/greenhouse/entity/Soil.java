package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlType
@XmlEnum
public enum Soil {
    @XmlEnumValue("podzolic")
    PODZOLIC("podzolic"),
    @XmlEnumValue("land_based")
    LAND_BASED("land-based");

    private final String title;

    Soil(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, Soil> LOOKUP_MAP = new HashMap<>();

    static {
        for (Soil soil : values()) {
            LOOKUP_MAP.put(soil.getTitle(), soil);
        }
    }

    public static Soil getSoilByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }
}
