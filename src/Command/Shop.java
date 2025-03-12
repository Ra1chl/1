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
            System.out.println("Trader: \"I want to buy everything from you!!\" \n Do you agree? Yes/No ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes")) {
                player.sellItem();

                System.out.println();
                return "You have" + player.getCredits() + "credits";
            }
        }
        return "You must be in station.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
