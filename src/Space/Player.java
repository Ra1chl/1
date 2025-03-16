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

    public void showInventory() {
        System.out.println("You have " + inventory.size() + " items");

        for (Item item : inventory) {
            System.out.println(item);
        }

    }

    public void addItem(Item item) {
        // Přidání předmětu do inventáře
        if (inventory.size() < 21){
            inventory.add(item);
            System.out.println("You put "+ item.getItemName() + " into the inventory");
        }else {
            System.out.println("You have full inventory. Go back to the station");
        }
    }

    public void removeItem(Item item) {
        // Odebrání předmětu z inventáře
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

    public int getCredits() {
        return credits;
    }

    public String getName() {
        return name;
    }
}
