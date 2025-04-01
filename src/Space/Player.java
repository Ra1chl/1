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
        System.out.println("Máš " + inventory.size() + " itemů.");

        for (Item item : inventory) {
            System.out.println(item);
        }

    }

    public void addItem(Item item) {
        // Přidání předmětu do inventáře
        if (inventory.size() < 3) {
            inventory.add(item);
            System.out.println("Vytěžil si " + item.getItemName() + " a uložil si ho do inventáře.");
        } else {
            System.out.println("Máš plný inventář. Vrať se na STANICI.");
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

    public String healPlayer(){

        if (this.health < 100 ){
            this.health = 100;
            return "You healed " + this.health + " health!";
        }else {
            return "You are full. Go back to the station";
        }
    }

    public void sellItem() {
        int sumPrice = 0;

        for (Item i : inventory) {
            sumPrice += i.getPrice();
        }

        inventory.clear();

        this.credits += sumPrice;
        System.out.println("Všechny předmety prodany");

    }

    public boolean spendCredits(int amount) {
        if (credits >= amount) {
            credits -= amount;
            return true;
        }
        return false;
    }

    public void increaseAttackPower() {
        attackPower += 5;
        System.out.println("Síla útoku zvýšena na " + attackPower);
    }

    public void increaseHealth() {
        health += 20;
        System.out.println("Zdraví zvýšeno na " + health);
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
