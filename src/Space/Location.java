package Space;

import java.util.ArrayList;

public abstract class Location {

    public String name;
    public String info;
    public String typeOfItem;
    public String typeOfNPC;
    public ArrayList<String> neighbors;

    public Location(String name,String info,String typeOfItem,String typeOfNPC, ArrayList<String> neighbors) {
        this.name = name;
        this.info = info;
        this.typeOfItem = typeOfItem;
        this.typeOfNPC = typeOfNPC;
        this.neighbors = neighbors;
    }

    // Ověření jestli lze jít na sousední lokaci
    public boolean canMoveTo(String destination) {
        return neighbors.contains(destination);
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public String getTypeOfNPC() {
        return typeOfNPC;
    }

    public ArrayList<String> getNeighbors() {
        return neighbors;
    }
}
