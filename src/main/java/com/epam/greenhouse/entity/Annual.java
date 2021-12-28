package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement(name = "annual")
public class Annual extends Flower {
   @XmlElement
   private Months plantingTime;

   public Annual() {
   }

   public Annual(UUID id, String name, Soil soil, VisualParameters visual, GrowingTips growing, Months plantingTime) {
      super(id, name, soil, visual, growing);
      this.plantingTime = plantingTime;
   }

   public void setPlantingTime(Months plantingTime) {
      this.plantingTime = plantingTime;
   }

   public Months getPlantingTime() {
      return plantingTime;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Annual annual = (Annual) o;
      return plantingTime == annual.plantingTime;
   }

   @Override
   public int hashCode() {
      int result = 31*super.hashCode();
      result = 31*result + plantingTime.hashCode();
      return result;
   }

   @Override
   public String toString() {
      return "Annual{" +
              "plantingTime=" + plantingTime +
              '}';
   }
}
