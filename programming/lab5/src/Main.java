public class Main {
    public static void main(String[] args) {
        Commander commander = new Commander(System.getenv("FILENAME"));
        commander.start();
    }
}