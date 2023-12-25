public class Go extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.println(a.name() + " топает");
    }
}
