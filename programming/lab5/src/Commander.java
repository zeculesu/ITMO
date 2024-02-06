import java.util.Scanner;

public class Commander {
    String filename;
    String[] commandlist;

    public Commander(String filename) {
        this.filename = filename;
        System.out.println(filename);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Enter your command, to exit write \"end\"");
        do {
            command = scanner.nextLine();
            System.out.println(command);
        }
        while(!command.equals("end"));
    }
}
