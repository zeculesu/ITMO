package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.*;

public class Ariados extends Pokemon{
    public Ariados(String name, int lvl){
        super(name, lvl);
        setStats(70, 90, 70, 60, 70, 40);
        setType(Type.BUG, Type.POISON);
        setMove(new Absorb(),  new Cross_Poison(), new Toxic_Thread(), new Venom_Drench());
    }
}
