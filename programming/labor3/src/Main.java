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
        Cloth policemanUniform = new Cloth("blue", "cotton", TypeCloth.UNIFORM);
        policeman.putOn(policemanUniform);
        Cloth button = new Cloth("silver", "metal", TypeCloth.BUTTONCLOTH);
        policeman.putOn(button);
        Cloth helmet = new Cloth("orange","copper", TypeCloth.HELMET);
        policeman.putOn(helmet);
        Baton baton = new Baton("blue", "rubber");
        policeman.take(baton);
        Pistol pistol = new Pistol(null, null);
        policeman.take(pistol);
        Cloth holster = new Cloth(null, null, TypeCloth.HOLSTER);
        policeman.putOn(holster);
    }
}