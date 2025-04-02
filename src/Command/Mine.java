package Command;

import Space.*;

/**
 * Třída Mine implementuje příkaz pro těžbu surovin.
 */
public class Mine implements Command {
    private Player player;
    private static Game game;
    private static LoadMap loader;

    /**
     * Konstruktor třídy Mine.
     *
     * @param player Hráč, který těží suroviny.
     * @param game Hra, ve které se hráč nachází.
     * @param loader Načítání mapy.
     */
    public Mine(Player player, Game game, LoadMap loader) {
        this.player = player;
        this.game = game;
        this.loader = loader;
    }

    /**
     * Provádí těžbu surovin na aktuální lokaci.
     *
     * @return Zpráva o výsledku těžby.
     */
    public String execute() {
        String itemName = game.getCurrentLocation().getTypeOfItem();

        switch (itemName) {
            case "redStone":
                Item item1 = new Item("Red Stone", 10, "Blood red stone from blood planet.");
                player.addItem(item1);
                break;

            case "blueStone":
                Item item2 = new Item("Blue Stone", 15, "Ice blue stone from frozen planet.");
                player.addItem(item2);
                break;

            case "yellowStone":
                Item item3 = new Item("Yellow Stone", 20, "Radioactive stone");
                player.addItem(item3);
                break;

            case "grayStone":
                Item item4 = new Item("Gray Stone", 30, "Ice gray stone");
                player.addItem(item4);
                break;

            case "emeraldStone":
                Item item5 = new Item("Emerald Stone", 100, "Emerald stone");
                player.addItem(item5);
                break;

            case "nothing":
                System.out.println("There is nothing to mine in this location.");
                break;
        }
        return"DONE";
    }



    @Override
    public boolean exit() {
        return false;
    }
}
