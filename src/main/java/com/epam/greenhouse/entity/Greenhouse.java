package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="flowers")
@XmlAccessorType(XmlAccessType.FIELD)

public class Greenhouse {

    private List<Flower> listFlowers;

    @XmlElements({
            @XmlElement(name="annual", namespace="http://www.example.com/flowers", type=Annual.class),
            @XmlElement(name="perennial",namespace="http://www.example.com/flowers", type=Perennial.class)
    })

    public List<Flower> getFlowers() {
        return listFlowers;
    }

    public void setFlowers(List<Flower> listFlowers) {
        this.listFlowers = listFlowers;
    }
}
