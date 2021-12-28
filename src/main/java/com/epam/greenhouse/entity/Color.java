package com.epam.greenhouse.entity;


import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlType
public enum Color {
    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("blue")
    BLUE("blue"),
    @XmlEnumValue("yellow")
    YELLOW("yellow"),
    @XmlEnumValue("red")
    RED("red"),
    @XmlEnumValue("violet")
    VIOLET("violet"),
    @XmlEnumValue("orange")
    ORANGE("orange"),
    @XmlEnumValue("pink")
    PINK("pink");

    private final String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, Color> LOOKUP_MAP = new HashMap<>();

    static {
        for (Color color : values()) {
            LOOKUP_MAP.put(color.getTitle(), color);
        }
    }

    public static Color getColorByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }
}
