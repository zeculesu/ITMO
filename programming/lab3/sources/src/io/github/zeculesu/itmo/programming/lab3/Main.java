package io.github.zeculesu.itmo.programming.lab3;

import io.github.zeculesu.itmo.programming.lab3.cloth.*;
import io.github.zeculesu.itmo.programming.lab3.weapon.*;

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
    }
}