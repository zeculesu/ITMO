public class PullAway extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.println(a.name() + " оттащен");
    }
}
