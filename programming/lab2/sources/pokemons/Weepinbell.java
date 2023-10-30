package pokemons;

import moves.Sludge_Bomb;
import moves.Swagger;
import moves.Poison_Powder;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Weepinbell extends Pokemon {
    public Weepinbell(String name, int lvl) {
        super(name, lvl);
        setStats(65, 90, 50, 85, 45, 55);
        setType(Type.GRASS, Type.POISON);
        setMove(new Sludge_Bomb(), new Swagger(), new Poison_Powder());
    }
}
