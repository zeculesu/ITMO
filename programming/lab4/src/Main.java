public class Main {
    public static void main(String[] args) {
        Human waiter = new Human("��������", Mood.NORMAL, 15);
        Human.Thought.think(waiter.name(), "loh");
//        waiter.setMood(Mood.SAD);
//        waiter.doSomething(new TurnPale());
//        waiter.setMood(Mood.AGRY);
//        Human dunno = new Human("��������", Mood.NORMAL, 16);
//        waiter.doSomethingWithWhom(new Grab(), dunno); //�������� ������� ��������
//        waiter.doSomethingWithWhom(new PullAway(), dunno); // �������� ������� ��������
//        Whistle whist = new Whistle(null, "plastic");
//        waiter.take(whist);
//        waiter.damage(dunno, whist);
//        Human policeman = new Human("�����������", Mood.NORMAL, 18);
//        Cloth policemanUniform = new Cloth("blue", "cotton", TypeCloth.UNIFORM);
//        policeman.take(policemanUniform);
//        Cloth button = new Cloth("silver", "metal", TypeCloth.BUTTONCLOTH);
//        policeman.take(button);
//        Cloth helmet = new Cloth("orange","copper", TypeCloth.HELMET);
//        policeman.take(helmet);
//        Baton baton = new Baton("blue", "rubber");
//        policeman.take(baton);
//        Pistol pistol = new Pistol(null, null);
//        policeman.take(pistol);
//        Cloth holster = new Cloth(null, null, TypeCloth.HOLSTER);
//        policeman.take(holster);
//        System.out.println(policeman.getInventory());
    }
}
