package Command;

import Space.Game;
import Space.LoadMap;
import Space.Location;
import Space.Player;

import java.util.Scanner;

/**
 * Třída Heal implementuje příkaz pro léčení hráče.
 */
public class Heal implements Command {
    private Player player;
    private Game game;
    private LoadMap loader;
    private Location hangar;

    /**
     * Konstruktor třídy Heal.
     *
     * @param player Hráč, který se má léčit.
     * @param game Hra, ve které se hráč nachází.
     * @param loader Načítání mapy.
     */
    public Heal(Player player, Game game, LoadMap loader) {
        this.player = player;
        this.game = game;
        this.loader = loader;
        this.hangar = loader.findLocation("hangar");
    }

    /**
     * Provádí léčení hráče, pokud je v hangáru.
     *
     * @return Zpráva o léčení nebo o nutnosti být v hangáru.
     */
    public String execute() {
        if (game.getCurrentLocation().getName().equals(hangar.getName())) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Potřebujes opravit svou lod?");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("ano")) {

                return player.healPlayer();
            }
        }
        return "Musíš být v lokaci: HANGAR";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
