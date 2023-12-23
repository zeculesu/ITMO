public class DoNothing extends Action{

    @Override
    public void doIt(Namable a) {
        System.out.println(a.name() + " сделал ничего");
    }
}
