package io.github.zeculesu.itmo.programming.lab3;

import io.github.zeculesu.itmo.programming.lab3.cloth.Cloth;
import io.github.zeculesu.itmo.programming.lab3.weapon.Weapon;

import java.util.ArrayList;
import java.util.Objects;

public class Human implements Takeable, Moveable {
    private String name;
    private Mood mood;
    private int height;

    private Human takenBy;
    private Human moveBy;

    private ArrayList<Thing> inventory = new ArrayList<>();

    private boolean damaged;

    public Human(String name, Mood mood, int height) {
        this.name = name;
        this.mood = mood;
        this.height = height;
        this.takenBy = null;
        this.damaged = false;
        System.out.println("Человек <" + name + "> появился в истории");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Human otherHuman)) return false;
        if (!(this.name.equals(otherHuman.name))) return false;
        if (!(this.mood.equals(otherHuman.mood))) return false;
        if (this.height != otherHuman.height) return false;
        return true;
    }

    @Override
    public String toString() {
        if (this.takenBy == null & this.moveBy == null) {
            return String.format("<Human name='%s' mood=%s height=%d takenBy=null moveBy=null damaged=%b>", this.name, this.mood, this.height, this.damaged);
        } else if (!(this.takenBy == null) & this.moveBy == null) {
            return String.format("<Human name='%s' mood=%s height=%d takenBy=%s moveBy=null damaged=%b>", this.name, this.mood, this.height, this.takenBy.getName(), this.damaged);
        } else if (this.takenBy == null & !(this.moveBy == null)) {
            return String.format("<Human name='%s' mood=%s height=%d takenBy=null moveBy=%s damaged=%b>", this.name, this.mood, this.height, this.moveBy.getName(), this.damaged);
        }
        return String.format("<Human name='%s' mood=%s height=%d takenBy=%s moveBy=%s damaged=%b>", this.name, this.mood, this.height, this.takenBy.getName(), this.moveBy.getName(), this.damaged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.mood, this.height);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Mood getMood() {
        return this.mood;
    }

    public void setMood(Mood newMood) {
        System.out.println(this.getName() + " сменил настроение с " + this.getMood() + " на " + newMood);
        this.mood = newMood;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    @Override
    public Human getTakenBy() {
        return this.takenBy;
    }

    @Override
    public void setTakenBy(Human by) {
        this.takenBy = by;
        System.out.println(this.getName() + " схвачен человеком " + by.getName());
    }

    public boolean getDamaged() {
        return this.damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    @Override
    public Object getMovedBy() {
        return this.moveBy;
    }

    @Override
    public void setMovedBy(Human by) {
        this.moveBy = by;
        System.out.println(this.getName() + " перемещен человеком " + by.getName());
    }

    public ArrayList<Thing> getInventory() {
        return this.inventory;
    }

    public void damage(Object whom, Weapon weapon) {
        if (whom instanceof Human){
            Human whomSb = (Human) whom;
            System.out.println(this.getName() + " наносит урон человеку " + whomSb.getName() + " с помощью " + weapon.getName());
        }
        else{
            Thing whomSb = (Thing) whom;
            System.out.println(this.getName() + " наносит урон предмету " + whomSb.getName() + " с помощью " + weapon.getName());
        }
        weapon.gamage(whom);
    }

    public void putOn(Cloth obj) {
        obj.setPutOnBy(this);
        this.inventory.add(obj);
        System.out.println(this.getName() + " надел предмет " + obj.getName());
    }

    public void take(Thing obj) {
        obj.setTakenBy(this);
        this.inventory.add(obj);
        System.out.println(this.getName() + " взял предмет " + obj.getName());
    }
}
