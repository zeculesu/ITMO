package moves;

import ru.ifmo.se.pokemon.*;

public class Bite extends PhysicalMove{
    public Bite(){
        super(Type.DARK, 60, 100);
    }

    @Override
    protected String describe() {
        return "укусил Bite";
    }
}
