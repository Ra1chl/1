import java.util.HashMap;
import java.util.Scanner;
import Command.*;
import Space.*;

/**
 * Třída Console slouží jako uživatelské rozhraní pro interakci s hrou.
 * Umožňuje hráči zadávat příkazy a provádět akce ve hře.
 */
public class Console {
    private HashMap<String, Command> map = new HashMap<>();
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor třídy Console.
     * Inicializuje příkazy, které hráč může použít.
     *
     * @param game Hra, ve které se hráč nachází.
     * @param loader Načítání mapy.
     * @param moveCommand Příkaz pro pohyb.
     * @param inventory Příkaz pro zobrazení inventáře.
     * @param shop Příkaz pro obchod.
     * @param mine Příkaz pro těžbu.
     * @param info Příkaz pro zobrazení informací.
     * @param player Hráč.
     * @param heal Příkaz pro léčení.
     * @param upgrade Příkaz pro vylepšení.
     */
    public Console(Game game, LoadMap loader, Move moveCommand, Inventory inventory, Shop shop, Mine mine, Info info, Player player, Heal heal,Upgrade upgrade) {
        map.put("stop", new Quit());
        map.put("move", moveCommand);
        map.put("inventory", inventory);
        map.put("shop", shop);
        map.put("mine", mine);
        map.put("info", info);
        map.put("heal", heal);
        map.put("upgrade", upgrade);

        // Přidáme boj
        Enemy bandit = new Enemy("Bandit", 50, 8);
        map.put("fight", new Fight(player, bandit));
    }

    /**
     * Zpracovává příkazy zadané uživatelem.
     * Kontroluje, zda je příkaz platný a provádí odpovídající akci.
     */
    public void doCommand() {
        System.out.print(">> ");
        String command = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(command)) {
            System.out.println(map.get(command).execute());
        } else {
            System.out.println(">> Nedefinovaný příkaz");
        }
    }

    /**
     * Spouští herní smyčku, která zpracovává příkazy, dokud hráč neukončí hru.
     */
    public void start() {
        try {
            do {
                doCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

