import java.util.HashMap;
import java.util.Scanner;
import Command.*;
import Space.*;

public class Console {
    private HashMap<String, Command> map = new HashMap<>();
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);

    public Console(Game game, LoadMap loader, Move moveCommand) {
        map.put("stop", new Quit());
        map.put("move", moveCommand);
    }

    public void doCommand() {
        System.out.print(">> ");
        String command = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
        } else {
            System.out.println(">> Nedefinovaný příkaz");
        }
    }

    public void start() {
        try {
            do {
                doCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

