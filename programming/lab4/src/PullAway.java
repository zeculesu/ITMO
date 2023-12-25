public class PullAway extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.print(a.name() + " оттащен");
    }
}
