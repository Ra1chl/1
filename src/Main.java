import Command.*;
import Space.LoadMap;
import Space.Location;
import Space.Game;
import Space.Player;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoadMap loader = new LoadMap();
        if (!loader.loadMap()) {
            System.out.println("Chyba při načítání mapy!");
            return;
        }

        // Nastavení startovní lokace
        Location startLocation = loader.findLocation("ship");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return;
        }

        Game game = new Game(startLocation);

        // Vytvoření hráče
        Player player = new Player("Captain", 100, new ArrayList<>());

        Move moveCommand = new Move(game, loader);
        Inventory inventory = new Inventory(player);
        Shop shop = new Shop(player,game,loader);
        Mine mine = new Mine(player,game,loader);
        Info info = new Info(game);

        Console c = new Console(game, loader, moveCommand, inventory,shop,mine,info);
        c.start();

    }
}