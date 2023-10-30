package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Poison_Powder extends StatusMove {
    public Poison_Powder() {
        super(Type.POISON, 0, 75);
    }

    @Override
    protected String describe() {
        return "использована атака Poison Powder";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (!p.hasType(Type.POISON) || !p.hasType(Type.STEEL)) {
            Effect.poison(p);
        }
    }
}