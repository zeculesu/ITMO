package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cross_Poison extends PhysicalMove {
    public Cross_Poison(){
        super(Type.POISON, 70, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1)
            Effect.poison(p);
    }

    @Override
    protected String describe() {
        return "ультанул Absorb";
    }
}
