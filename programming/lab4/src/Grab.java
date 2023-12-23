public class Grab extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.println(a.name() + " схвачен");
    }
}
