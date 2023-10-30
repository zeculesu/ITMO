package moves;

import ru.ifmo.se.pokemon.*;

public class Toxic_Thread extends StatusMove {
    public Toxic_Thread(){
        super(Type.POISON, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.poison(p);
        p.setMod(Stat.SPEED, 1);
    }

    @Override
    protected String describe() {
        return "применил Toxic Thread";
    }
}
