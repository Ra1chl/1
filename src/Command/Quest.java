package Command;

import Space.Game;
import Space.LoadMap;
import Space.NPC;
import Space.Player;

/**
 * Třída Quest implementuje příkaz pro interakci s NPC a plnění úkolů.
 */
public class Quest implements Command {
private Player player;
private Game game;
private LoadMap loadMap;
private NPC npc;

    /**
     * Konstruktor třídy Quest.
     *
     * @param player Hráč, který plní úkoly.
     * @param game Hra, ve které se hráč nachází.
     * @param loadMap Načítání mapy.
     */
    public Quest(Player player, Game game, LoadMap loadMap) {
        this.player = player;
        this.game = game;
        this.loadMap = loadMap;
    }

    /**
     * Provádí interakci s NPC na aktuální lokaci.
     *
     * @return Zpráva o interakci s NPC.
     */
    public String execute() {
        String location = game.getCurrentLocation().getName();

        //tady potrebuju dodelat aby to poznalo kde aktualne jsem a jestli mohu s npc mluvit
        String nameOfNPC = game.getCurrentLocation().getTypeOfNPC();
        npc.interact(nameOfNPC);

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
