package pokemons;

import moves.Bite;
import moves.Confide;
import moves.Feint_Attack;
import moves.Shadow_Ball;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Mawile extends Pokemon {
    public Mawile (String name, int lvl){
        super(name, lvl);
        setStats(50, 85, 85, 55, 55, 50);
        setType(Type.STEEL, Type.FAIRY);
        setMove(new Bite(), new Confide(), new Feint_Attack(), new Shadow_Ball());
    }
}
