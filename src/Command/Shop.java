package Command;
import Space.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Třída Shop implementuje příkaz pro obchodování s hráčem.
 */
public class Shop implements Command {
    private Player player;
    private Game game;
    private LoadMap loader;
    private Location station;

    /**
     * Konstruktor třídy Shop.
     *
     * @param player Hráč, který obchoduje.
     * @param game Hra, ve které se hráč nachází.
     * @param loader Načítání mapy.
     */
    public Shop(Player player, Game game, LoadMap loader) {
        this.player = player;
        this.game = game;
        this.loader = loader;
        this.station = loader.findLocation("station");
    }

    /**
     * Provádí obchodování s hráčem, včetně prodeje a vykoupení.
     *
     * @return Zpráva o výsledku obchodování.
     */
    public String execute() {
        if (!game.getCurrentLocation().getName().equals(station.getName())) {
            return "Musíš být v lokaci: STATION.";
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(
                        "╔════════════════════════════════╗\n" +
                        "║   🛒 Vítej u obchodníka! 🛒   ║\n" +
                        "╠════════════════════════════════╣\n" +
                        "║ 1. Prodat všechny věci        ║\n" +
                        "║ 2. Vykoupit se z dluhu (1000₭)║\n" +
                        "╚════════════════════════════════╝\n" +
                        "Zadej volbu: "
        );

        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            return "⚠ Neplatný vstup! Zadej číslo 1 nebo 2. ⚠";
        }

        switch (choice) {
            case 1:
                player.sellItem();
                return "Máš " + player.getCredits() + " kreditů.";

            case 2:
                if (player.spendCredits(1000)) {
                    return player.clearDebt();
                } else {
                    return "Nemáš dost kreditů na vykoupení!";
                }

            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
