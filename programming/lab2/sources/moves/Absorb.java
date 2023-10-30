package moves;

import ru.ifmo.se.pokemon.*;

public class Absorb extends SpecialMove {
    public Absorb() {
        super(Type.GRASS, 20, 100);
    }

    @Override
    protected String describe() {
        return "атакует с помощью Absorb";
    }
}
