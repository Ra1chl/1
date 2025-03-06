package Command;

import Space.*;
import java.util.Scanner;

public class Move implements Command {
    private Game game;
    private LoadMap loader;

    public Move() {
        this.game = game;
        this.loader = loader;
    }

    public String execute() {
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
            return "Přesunul ses na " + destination.name;
        } else {
            return "Nemůžeš se tam přesunout!";
        }
    }

    public boolean exit() {
        return false;
    }
}
