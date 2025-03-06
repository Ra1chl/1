package Command;

import Space.*;
import java.util.Scanner;

public class Move implements Command {
    private static Game game;
    private static LoadMap loader;
    private static boolean firstMove = true;

    public Move(Game gameInstance, LoadMap loadMapInstance) {
        game = gameInstance;
        loader = loadMapInstance;
    }

    public String execute() {
        if (game == null || loader == null) {
            return "Hra nebyla správně inicializována!";
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nJsi na lokaci: " + game.getCurrentLocation().name);
        System.out.println(game.getCurrentLocation().info);
        game.showAvailableMoves();

        System.out.print("Kam chceš jít? (napiš název lokace): ");
        String input = scanner.nextLine().trim().toLowerCase();

        Location destination = loader.findLocation(input);
        if (destination == null) {
            return "Tato lokace neexistuje!";
        }

        if (game.moveTo(destination)) {
            firstMove = false;
            return "Přesunul ses na " + destination.name;
        } else {
            return "Nemůžeš se tam přesunout!";
        }
    }

    public boolean exit() {
        return false;
    }
}
