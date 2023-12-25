public class Smelling extends Action{
    @Override
    public void doIt(Namable a) {
        System.out.print(a.name() + " была понюхана");
    }
}
