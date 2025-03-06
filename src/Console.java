import java.util.HashMap;
import java.util.Scanner;

import Command.*;
import Space.Game;
import Space.LoadMap;

public class Console {
    private HashMap<String, Command> map = new HashMap<>();
    private boolean exit = false;

    private Game game;
    private LoadMap loader;

    public void inicialization() {
        map.put("stop", new Quit());
        map.put("move", new Move());
    }

    private Scanner scanner = new Scanner(System.in);

    public void doCommand() {
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
        } else {
            System.out.println(">> Nondefined command");
        }
    }

    public void start() {
        inicialization();
        try {
            do {
                doCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
