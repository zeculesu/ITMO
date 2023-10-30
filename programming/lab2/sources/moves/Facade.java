package moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (p.getCondition() == Status.POISON || p.getCondition() == Status.BURN){
            applyOppDamage(p, -70);
        }
    }

    @Override
    protected String describe(){
        return "атакует Facade";
    }

}
