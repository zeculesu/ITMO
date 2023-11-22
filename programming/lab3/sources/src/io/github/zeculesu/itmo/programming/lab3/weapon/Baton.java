package io.github.zeculesu.itmo.programming.lab3.weapon;

import io.github.zeculesu.itmo.programming.lab3.Attack;
import io.github.zeculesu.itmo.programming.lab3.weapon.Weapon;

public class Baton extends Weapon {

    public Baton(String color, String material) {
        super(color, material, Attack.PHYSICAL);
        this.setName("Дубинка");
    }
}
