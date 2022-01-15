package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlType
public enum Months {
    @XmlEnumValue("january")
    JANUARY("january"),
    @XmlEnumValue("february")
    FEBRUARY("february"),
    @XmlEnumValue("march")
    MARCH("march"),
    @XmlEnumValue("april")
    APRIL("april"),
    @XmlEnumValue("may")
    MAY("may"),
    @XmlEnumValue("june")
    JUNE("june"),
    @XmlEnumValue("july")
    JULY("july"),
    @XmlEnumValue("august")
    AUGUST("august"),
    @XmlEnumValue("september")
    SEPTEMBER("september"),
    @XmlEnumValue("october")
    OCTOBER("october"),
    @XmlEnumValue("november")
    NOVEMBER("november"),
    @XmlEnumValue("december")
    DECEMBER("december");

    private final String title;

    Months(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, Months> LOOKUP_MAP = new HashMap<>();

    static {
        for (Months month : values()) {
            LOOKUP_MAP.put(month.getTitle(), month);
        }
    }

    public static Months getMonthByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }
}
