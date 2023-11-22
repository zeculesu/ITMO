public class Main {
    public static void main(String[] args) {
        Human Alice = new Human("Alice", Mood.NORMAL, 21);
        System.out.println(Alice.toString());
        Human Robert = new Human("Robert", Mood.NORMAL, 21);
        // РОБЕРТ ВЗЯЛ АЛИСУ
        Alice.setTakenBy(Robert);
    }
}