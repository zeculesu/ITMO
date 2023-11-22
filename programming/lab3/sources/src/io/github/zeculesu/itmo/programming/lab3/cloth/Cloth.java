package io.github.zeculesu.itmo.programming.lab3.cloth;

import io.github.zeculesu.itmo.programming.lab3.Human;
import io.github.zeculesu.itmo.programming.lab3.Thing;

import java.util.Objects;

public class Cloth extends Thing {
    private Human putOnBy;

    public Cloth(String color, String material){
        this.setColor(color);
        this.setMaterial(material);
    }

    @Override
    public String toString() {
        return String.format("<Cloth color=%s material=%s putOnBy=%s takenBy=%s movedBy=%s>", this.getColor(), this.getMaterial(), this.getPutOnBy(), this.getTakenBy(), this.getMovedBy());
    }
    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (!(this.getClass().isInstance(other))) return false;
        Cloth otherCloth = (Cloth) other;
        if (!(this.getColor().equals(otherCloth.getColor()))) return false;
        if (!(this.getMaterial().equals(otherCloth.getMaterial()))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getColor(), this.getMaterial());
    }


    public Human getPutOnBy() {
        return this.putOnBy;
    }

    public void setPutOnBy(Human putOnBy) {
        this.putOnBy = putOnBy;
    }
}
