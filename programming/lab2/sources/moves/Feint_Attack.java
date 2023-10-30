package moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Feint_Attack extends PhysicalMove {
    public Feint_Attack(){
        super(Type.DARK, 60, 100);
    }

    @Override
    protected String describe() {
        return "применена атака Feint Attack";
    }
}
