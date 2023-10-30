package moves;

import ru.ifmo.se.pokemon.*;

public class Sludge_Bomb extends SpecialMove {
    public Sludge_Bomb() {
        super(Type.POISON, 90, 100);
    }

    @Override
    protected String describe() {
        return "использует Sludge Bomb";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3)
            Effect.poison(p);
    }
}