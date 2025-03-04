package Space;

import java.util.ArrayList;

public class Player {
    private String name;
    private int credits; // Peníze
    private ArrayList<Item> inventory;

    public Player(String name, int credits, ArrayList<Item> inventory) {
        this.name = name;
        this.credits = 100;
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        // Přidání předmětu do inventáře
    }

    public void removeItem(Item item) {
        // Odebrání předmětu z inventáře
    }

    public void buyItem(Item item, int price) {
        // Koupě předmětu
    }

    public void sellItem(Item item, int price) {
        // Prodej předmětu
    }
}
