import java.util.ArrayList;
import java.util.Scanner;

public class Commander {
    private String filename;
    private ArrayList<String> commandlist = new ArrayList<>();

    public Commander(String filename) {
        this.filename = filename;
        System.out.println("filename with command " +filename);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Enter your command, to exit write \"exit\"");
        do {
            command = scanner.nextLine();
            this.commandlist.add(command);
            executionCommand(command);
        }
        while (!command.equals("exit"));
    }

    void executionCommand(String command) {
        String[] command_argument = command.split(" ");
        if (command_argument.length == 2) {
            String[] argument = command_argument[1].split(";");
        }
        switch (command_argument[0]) {
            case ("help"): System.out.println("You need my help?");
            case ("info"):
            case ("show"):
            case ("add"):
            case ("update"):
            case ("remove_by_id"):
            case ("clear"):
            case ("save"):
            case ("execute_script"):
            case ("remove_head"):
            case ("remove_lower"):
            case ("history"):
            case ("remove_all_by_melee_weapon"):
            case ("filter_starts_with_name"):
            case ("print_field_descending_health"):
        }
    }
}
