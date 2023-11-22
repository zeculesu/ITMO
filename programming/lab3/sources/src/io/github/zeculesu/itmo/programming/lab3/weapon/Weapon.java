package io.github.zeculesu.itmo.programming.lab3.weapon;

import io.github.zeculesu.itmo.programming.lab3.Attack;
import io.github.zeculesu.itmo.programming.lab3.Human;
import io.github.zeculesu.itmo.programming.lab3.Thing;
import io.github.zeculesu.itmo.programming.lab3.cloth.Cloth;

import java.util.Objects;

public class Weapon extends Thing {
    private Attack typeAttack;

    public Weapon(String color, String material, Attack typeAttack){
        this.setColor(color);
        this.setMaterial(material);
        this.typeAttack = typeAttack;
    }

    @Override
    public String toString() {
        return String.format("<Weapon color=%s material=%s typeAttack=%s takenBy=%s movedBy=%s>", this.getColor(), this.getMaterial(), this.getTypeAttack(), this.getTakenBy(), this.getMovedBy());
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (!(this.getClass().isInstance(other))) return false;
        Weapon otherWeapon = (Weapon) other;
        if (!(this.getColor().equals(otherWeapon.getColor()))) return false;
        if (!(this.getMaterial().equals(otherWeapon.getMaterial()))) return false;
        if (!(this.getTypeAttack().equals(otherWeapon.getTypeAttack()))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getColor(), this.getMaterial(), this.getTypeAttack());
    }

    public void gamage(Object whom) {
        if (!(whom instanceof Human) & !(whom instanceof Thing)){
            System.out.println("Это нельзя повредить");
        }
        if (whom instanceof Human whoHuman) {
            whoHuman.setDamaged(true);
        } else if ((whom instanceof Thing whoThing) ) {
            whoThing.setDamaged(true);
        }
    }

    public Attack getTypeAttack() {
        return this.typeAttack;
    }

    public void setTypeAttack(Attack typeAttack) {
        this.typeAttack = typeAttack;
    }
}
