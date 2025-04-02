package Space;

import java.util.ArrayList;

/**
 * Třída Player reprezentuje hráče ve hře.
 * Uchovává informace o zdraví, síle útoku, kreditech a inventáři.
 */
public class Player {
    private String name;
    private int health;
    private int attackPower;
    private int credits; // Peníze
    private ArrayList<Item> inventory;

    /**
     * Konstruktor třídy Player.
     * Inicializuje hráče s daným jménem, kredity a inventářem.
     *
     * @param name      Jméno hráče.
     * @param credits   Počáteční kredity hráče.
     * @param inventory Inventář hráče.
     */
    public Player(String name, int credits, ArrayList<Item> inventory) {
        this.name = name;
        this.health = 100;  // Výchozí zdraví
        this.attackPower = 10;  // Výchozí síla útoku
        this.credits = 100;
        this.inventory = inventory;
    }

    /**
     * Zobrazí obsah inventáře hráče.
     */
    public void showInventory() {
        System.out.println("Máš " + inventory.size() + " itemů.");

        for (Item item : inventory) {
            System.out.println(item);
        }

    }

    /**
     * Přidá předmět do inventáře hráče.
     *
     * @param item Předmět, který se má přidat.
     */
    public void addItem(Item item) {
        // Přidání předmětu do inventáře
        if (inventory.size() < 3) {
            inventory.add(item);
            System.out.println("Vytěžil si " + item.getItemName() + " a uložil si ho do inventáře.");
        } else {
            System.out.println("Máš plný inventář. Vrať se na STANICI.");
        }
    }

    /**
     * Útočí na nepřítele a způsobí mu poškození.
     *
     * @param enemy Nepřítel, na kterého se útočí.
     */
    public void attack(Enemy enemy) {
        enemy.takeDamage(attackPower);
        System.out.println("You attacked " + enemy.getName() + " for " + attackPower + " damage!");
    }

    /**
     * Přijímá poškození od nepřítele.
     *
     * @param damage Poškození, které hráč utrpěl.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println("You took " + damage + " damage! Remaining health: " + health);
    }

    /**
     * Kontroluje, zda je hráč naživu.
     *
     * @return true, pokud je hráč naživu; jinak false.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Léčí hráče na maximální zdraví.
     *
     * @return Zpráva o léčení.
     */
    public String healPlayer() {

        if (this.health < 100) {
            this.health = 100;
            return "You healed " + this.health + " health!";
        } else {
            return "You are full. Go back to the station";
        }
    }

    /**
     * Prodává všechny předměty v inventáři a přidává kredity.
     */
    public void sellItem() {
        int sumPrice = 0;

        for (Item i : inventory) {
            sumPrice += i.getPrice();
        }

        inventory.clear();

        this.credits += sumPrice;
        System.out.println("Všechny předmety prodany");

    }

    /**
     * Utrácí kredity hráče.
     *
     * @param amount Částka, kterou chce hráč utratit.
     * @return true, pokud má hráč dostatek kreditů; jinak false.
     */
    public boolean spendCredits(int amount) {
        if (credits >= amount) {
            credits -= amount;
            return true;
        }
        return false;
    }

    /**
     * Zvyšuje sílu útoku hráče.
     */
    public void increaseAttackPower() {
        attackPower += 5;
        System.out.println("Síla útoku zvýšena na " + attackPower);
    }

    /**
     * Zvyšuje zdraví hráče.
     */
    public void increaseHealth() {
        health += 20;
        System.out.println("Zdraví zvýšeno na " + health);
    }


    public String clearDebt() {
        return "╔══════════════════════════════════════════╗\n" +
                "║  🎉 GRATULUJEME! 🎉                     ║\n" +
                "╠══════════════════════════════════════════╣\n" +
                "║ Splatil jsi svůj dluh a nyní můžeš      ║\n" +
                "║ v klidu žít se svou rodinou.           ║\n" +
                "║ Tvůj příběh je u konce... nebo ne?     ║\n" +
                "╚══════════════════════════════════════════╝";

    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getCredits() {
        return credits;
    }

    public String getName() {
        return name;
    }
}
