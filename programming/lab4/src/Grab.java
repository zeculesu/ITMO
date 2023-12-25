public class Grab extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.print(a.name() + " схвачен");
    }
}
