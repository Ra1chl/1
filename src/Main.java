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

        // Vytvoření hráče
        Player player = new Player("Captain", 100, new ArrayList<>());

        // Předání hráče do Game
        Game game = new Game(startLocation, player);

        Move moveCommand = new Move(game, loader);
        Inventory inventory = new Inventory(player);
        Shop shop = new Shop(player, game, loader);
        Mine mine = new Mine(player, game, loader);
        Info info = new Info(game);
        Heal heal = new Heal(player, game, loader);
        Upgrade upgrade = new Upgrade(player, game, loader);

        Console c = new Console(game, loader, moveCommand, inventory, shop, mine, info,player,heal,upgrade);

        System.out.println(
                "╔════════════════════════════════════════════╗\n" +
                        "║  🚀 VÍTEJ VE SVÉ POSLEDNÍ ŠANCI! 🚀       ║\n" +
                        "╠════════════════════════════════════════════╣\n" +
                        "║ Jsi bývalý pilot, teď jen muž s dluhem,   ║\n" +
                        "║ který tě tíží jako gravitace černé díry.  ║\n" +
                        "║ Našel sis práci pro těžební korporaci,    ║\n" +
                        "║ která vydírá zoufalé kapitány jako jsi ty.║\n" +
                        "║ Tvým úkolem je těžit suroviny na planetách║\n" +
                        "║ – ale vesmír je temné a nebezpečné místo. ║\n" +
                        "║ Spravuj svou loď, přežij nástrahy a hlavně║\n" +
                        "║ splať svůj dluh... pokud chceš ještě vidět║\n" +
                        "║ svou rodinu.                              ║\n" +
                        "╚════════════════════════════════════════════╝"
        );
        System.out.println(
                "╔════════════════════════════════════════╗\n" +
                        "║           🛸 PŘEHLED PŘÍKAZŮ 🛸        ║\n" +
                        "╠════════════════════════════════════════╣\n" +
                        "║ 🚀 MOVE – Pohyb mezi lokacemi ve vesmíru.║\n" +
                        "║    Prozkoumávej, cestuj, přežívej!       ║\n" +
                        "║ 📦 INVENTORY – Zobraz svůj inventář.     ║\n" +
                        "║    Sleduj, co jsi nasbíral.              ║\n" +
                        "║ ⛏️ MINE – Těžba surovin v aktuální lokaci.║\n" +
                        "║    Ale pozor na nebezpečí!               ║\n" +
                        "║ 🏪 SHOP – Prodej své suroviny na STATION.║\n" +
                        "║    Vydělávej kredity na přežití.         ║\n" +
                        "║ 🔧 HEAL – Oprava lodi v HANGARU.         ║\n" +
                        "║    Udržuj svůj stroj v kondici!          ║\n" +
                        "║ 💪 UPGRADE – Vylepši své atributy.       ║\n" +
                        "║    Získej větší sílu a odolnost.         ║\n" +
                        "║ 📜 INFO – Zobraz seznam dostupných příkazů.║\n" +
                        "║ ✨ GAME – Zobraz hlavní cíl hry.         ║\n" +
                        "║ ❌ QUIT – Ukončení hry.                  ║\n" +
                        "╚════════════════════════════════════════╝"
        );
        c.start();
    }
}
