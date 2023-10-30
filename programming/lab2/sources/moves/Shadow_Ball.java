package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Shadow_Ball extends SpecialMove {
    public Shadow_Ball(){
        super(Type.GHOST, 80, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if (Math.random() <= 0.2) {
            p.setMod(Stat.SPECIAL_DEFENSE, 1);
        }
    }
}
