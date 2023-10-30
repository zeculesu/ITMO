package pokemons;

import moves.Absorb;
import moves.Cross_Poison;
import moves.Toxic_Thread;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Spinarak extends Pokemon {
    public Spinarak(String name, int lvl) {
        super(name, lvl);
        setStats(40, 60, 40, 40, 40, 30);
        setType(Type.BUG, Type.POISON);
        setMove(new Absorb(), new Cross_Poison(), new Toxic_Thread());
    }
}
