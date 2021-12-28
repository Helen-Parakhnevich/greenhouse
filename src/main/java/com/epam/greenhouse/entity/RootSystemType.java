package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum RootSystemType {
    @XmlEnumValue("fibrous")
    FIBROUS("fibrous"),
    @XmlEnumValue("bulb")
    BULB("bulb"),
    @XmlEnumValue("tubers")
    TUBERS("tubers");

    private final String title;

    RootSystemType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, RootSystemType> LOOKUP_MAP = new HashMap<>();

    static {
        for (RootSystemType root : values()) {
            LOOKUP_MAP.put(root.getTitle(), root);
        }
    }

    public static RootSystemType getRootByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }
}
