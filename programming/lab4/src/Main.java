public class Main {
    public static void main(String[] args) {
        try {

            Human dunno = new Human("Незнайка", Mood.NORMAL, 16);
            Human.Thought thought = dunno.new Thought("Это всё какое-то недоразумение или сон");
            thought.think();

            dunno.doSomething(new Action() {
                @Override
                public void doIt(Namable a) {
                    System.out.println(a.name() + " поднялся и помахал ручкой");
                }
            });

            dunno.doSomething(new Go());

            Human waiter = new Human("Официант", Mood.NORMAL, 15);

            waiter.doSomethingWithWhom(new Grab(), dunno);
            waiter.setMood(Mood.HAPPY);

            Human.Thought thought_waiter = waiter.new Thought("хочу что-то сказать, но не скажу");
            thought_waiter.think();

            waiter.setMood(Mood.SAD);
            waiter.doSomething(new TurnPale());
            waiter.setMood(Mood.AGRY);
            waiter.doSomethingWithWhom(new Grab(), dunno); //официант схватил незнайку
            waiter.doSomethingWithWhom(new PullAway(), dunno); // официант оттащил незнайку
            Whistle whist = new Whistle(null, "plastic");
            waiter.take(whist);
            waiter.damage(dunno, whist);
            Human policeman = new Human("Полицейский", Mood.NORMAL, 18);

            Human.HeightHuman.checkerHeight(policeman.getHeight());

            Cloth policemanUniform = new Cloth("blue", "cotton", TypeCloth.UNIFORM);
            policeman.take(policemanUniform);
            Cloth button = new Cloth("silver", "metal", TypeCloth.BUTTONCLOTH);
            policeman.take(button);
            Cloth helmet = new Cloth("orange", "copper", TypeCloth.HELMET);
            policeman.take(helmet);
            Baton baton = new Baton("blue", "rubber");
            policeman.take(baton);
            Pistol pistol = new Pistol(null, null);
            policeman.take(pistol);
            Cloth holster = new Cloth(null, null, TypeCloth.HOLSTER);
            policeman.take(holster);

            dunno.doSomething(new Action() {
                @Override
                public void doIt(Namable a) {
                    System.out.println(a.name() + " откинул голову назад");
                }
            });

            dunno.doSomethingWithWhom(new Smelling(), baton);

        }
        catch (DamageException ex){
            System.out.println("DamageException catched: " + ex.getMessage());
        }
        catch (NamingException ex){
            System.out.println("NamingException catched: " + ex.getMessage());
        }
    }
}
