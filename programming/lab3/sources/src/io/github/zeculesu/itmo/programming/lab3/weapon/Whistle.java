package io.github.zeculesu.itmo.programming.lab3.weapon;

import io.github.zeculesu.itmo.programming.lab3.Attack;
import io.github.zeculesu.itmo.programming.lab3.Human;
import io.github.zeculesu.itmo.programming.lab3.Thing;

public class Whistle extends Weapon {
    public Whistle(String color, String material){
        super(color, material, Attack.PSYCHOLOGICAL);
    }

    @Override
    public void gamage(Object whom) {
        if (!(whom instanceof Human) & !(whom instanceof Thing)){
            System.out.println("Это нельзя повредить");
        }
        System.out.println(this.getTakenBy().getName() + " свистит в свисток и психологически давит");
        if (whom instanceof Human whoHuman) {
            whoHuman.setDamaged(true);
        } else if ((whom instanceof Thing whoThing) ) {
            whoThing.setDamaged(true);
        }
    }
}
