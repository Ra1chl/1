package Command;
import Space.*;

import java.util.Scanner;

public class Shop implements Command {
    private Player player;
    private Game game;
    private LoadMap loader;
    private Location station;


    public Shop(Player player, Game game, LoadMap loader) {
        this.player = player;
        this.game = game;
        this.loader = loader;
        this.station = loader.findLocation("station");
    }


    public String execute() {
        if (game.getCurrentLocation().getName().equals(station.getName())) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Obchodník: \"Chci od tebe koupit všechno!!\" \n Souhlasíš? Ano/Ne ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("ano")) {
                player.sellItem();

                return "Máš " + player.getCredits() + " kreditů.";
            }
        }
        return "Musíš být v lokaci: STATION.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
