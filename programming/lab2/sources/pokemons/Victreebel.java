package pokemons;

import moves.Poison_Powder;
import moves.Sludge_Bomb;
import moves.Swagger;
import moves.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Victreebel extends Pokemon {
    public Victreebel(String name, int lvl) {
        super(name, lvl);
        setStats(80, 105, 65, 100, 70, 70);
        setType(Type.GRASS, Type.POISON);
        setMove(new Sludge_Bomb(), new Swagger(), new Poison_Powder(), new Facade());
    }
}
