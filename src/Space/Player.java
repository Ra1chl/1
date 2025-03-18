package Space;

import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private int attackPower;
    private int credits; // Peníze
    private ArrayList<Item> inventory;

    public Player(String name, int credits, ArrayList<Item> inventory) {
        this.name = name;
        this.health = 100;  // Výchozí zdraví
        this.attackPower = 10;  // Výchozí síla útoku
        this.credits = 100;
        this.inventory = inventory;
    }

    public void showInventory() {
        System.out.println("You have " + inventory.size() + " items");

        for (Item item : inventory) {
            System.out.println(item);
        }

    }

    public void addItem(Item item) {
        // Přidání předmětu do inventáře
        if (inventory.size() < 21) {
            inventory.add(item);
            System.out.println("You put " + item.getItemName() + " into the inventory");
        } else {
            System.out.println("You have full inventory. Go back to the station");
        }
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(attackPower);
        System.out.println("You attacked " + enemy.getName() + " for " + attackPower + " damage!");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println("You took " + damage + " damage! Remaining health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }


    public void buyItem(Item item, int price) {
        // Koupě předmětu
    }

    public void sellItem() {
        int sumPrice = 0;

        for (Item i : inventory) {
            sumPrice += i.getPrice();
        }

        inventory.clear();

        this.credits += sumPrice;
        System.out.println("test");

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
