package Command;
import Space.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Upgrade implements Command {
    private Player player;
    private Game game;
    private LoadMap loader;
    private Location ship;

    public Upgrade(Player player, Game game, LoadMap loader) {
        this.player = player;
        this.game = game;
        this.loader = loader;
        this.ship = loader.findLocation("ship");
    }

    public String execute() {
        if (!game.getCurrentLocation().getName().equals(ship.getName())) {
            return "Musíš být v lokaci: SHIP.";
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Co si chceš koupit?\n1. Zvýšení síly (30 kreditů)\n2. Zvýšení života (40 kreditů)");

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            return "⚠ Neplatný vstup! Zadej číslo 1 nebo 2. ⚠";
        }

        switch (choice) {
            case 1:
                if (player.spendCredits(30)) {
                    player.increaseAttackPower();
                    return "Síla zvýšena!";
                }
                break;
            case 2:
                if (player.spendCredits(40)) {
                    player.increaseHealth();
                    return "Život zvýšen!";
                }
                break;
            default:
                return "Neplatná volba.";
        }
        return "Nedostatek kreditů!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
