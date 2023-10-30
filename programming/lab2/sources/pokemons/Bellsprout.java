package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.Sludge_Bomb;
import moves.Swagger;

public class Bellsprout extends Pokemon {
    public Bellsprout(String name, int lvl) {
        super(name, lvl);
        setStats(50, 75, 35, 70, 30, 40);
        setType(Type.GRASS, Type.POISON);
        setMove(new Sludge_Bomb(), new Swagger());
    }
}
