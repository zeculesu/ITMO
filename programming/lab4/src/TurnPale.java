public class TurnPale extends Action{
    @Override
    public void doIt(Namable a) {
        System.out.println(a.name() + " побледнел");
    }
}
