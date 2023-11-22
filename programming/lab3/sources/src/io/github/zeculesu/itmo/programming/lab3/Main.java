package io.github.zeculesu.itmo.programming.lab3;

import io.github.zeculesu.itmo.programming.lab3.cloth.*;
import io.github.zeculesu.itmo.programming.lab3.weapon.Baton;
import io.github.zeculesu.itmo.programming.lab3.weapon.Pistol;
import io.github.zeculesu.itmo.programming.lab3.weapon.Whistle;

public class Main {
    public static void main(String[] args) {
        Human waiter = new Human("Официант", Mood.NORMAL, 15);
        waiter.setMood(Mood.SAD);
        waiter.setMood(Mood.AGRY);
        Human dunno = new Human("Незнайка", Mood.NORMAL, 16);
        dunno.setTakenBy(waiter);
        dunno.setMovedBy(waiter);
        Whistle whist = new Whistle(null, "plastic");
        waiter.take(whist);
        waiter.damage(dunno, whist);
        Human policeman = new Human("Полицейский", Mood.NORMAL, 18);
        Uniform policemanUniform = new Uniform("blue", "cotton");
        policeman.putOn(policemanUniform);
        ButtonCloth button = new ButtonCloth("silver", "metal");
        policeman.putOn(button);
        Helmet helmet = new Helmet("orange","copper");
        policeman.putOn(helmet);
        Baton baton = new Baton("blue", "rubber");
        policeman.take(baton);
        Pistol pistol = new Pistol(null, null);
        policeman.take(pistol);
        Holster holster = new Holster(null, null);
        policeman.putOn(holster);
//        Human Alice = new Human("Alice", Mood.NORMAL, 21);
//        System.out.println(Alice.toString());
//        Human Robert = new Human("Robert", Mood.NORMAL, 21);
        // РОБЕРТ ВЗЯЛ АЛИСУ
//        Alice.setTakenBy(Robert);
//        Alice.setMovedBy(Robert);
//        System.out.println(Alice);
//        Whistle kdf = new Whistle(null, "plastic");
//        Human Robert = new Human("Robert", Mood.NORMAL, 21);
//        Human Alice = new Human("Alice", Mood.NORMAL, 21);
//        Robert.take(kdf);
//        Robert.damage(Alice, kdf);
//        Robert.putOn(cloth_Robert);
//        System.out.println(Robert.getInventory());
    }
}