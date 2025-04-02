package Command;

import Space.*;
import java.util.Scanner;

/**
 * Třída Move implementuje příkaz pro pohyb hráče mezi lokacemi.
 */
public class Move implements Command {
    private static Game game;
    private static LoadMap loader;
    private static boolean firstMove = true;

    /**
     * Konstruktor třídy Move.
     *
     * @param gameInstance Instance hry.
     * @param loadMapInstance Instance načítání mapy.
     */
    public Move(Game gameInstance, LoadMap loadMapInstance) {
        game = gameInstance;
        loader = loadMapInstance;
    }

    /**
     * Provádí pohyb hráče na zvolenou lokaci.
     *
     * @return Zpráva o výsledku pohybu.
     */
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

        Player player = game.getPlayer();
        // Pokud je v lokaci nepřítel, aktivuje se boj
        if (destination.getTypeOfNPC().equals("bandit")) {
            Enemy bandit = new Enemy("Bandit", 50, 8);
            Fight fight = new Fight(player, bandit);
            fight.execute();

            if (!player.isAlive()) {
                return "Hráč byl poražen a musí se vrátit na základnu!";
            }
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
