package Space;

import java.util.ArrayList;

public class Player {
    private Location currentLocation;

    public Player(Location startingLocation) {
        this.currentLocation = startingLocation;
    }


    public boolean moveTo(Location destination) {
        if (currentLocation.canMoveTo(destination.name)) {
            currentLocation = destination;
            System.out.println("Přesunul ses na: " + destination.name);
            System.out.println(destination.info);
            return true;
        } else {
            System.out.println("Nemůžeš se tam přesunout!");
            return false;
        }
    }

    public void showAvailableMoves() {
        System.out.println("Můžeš se přesunout na:");
        for (String neighbor : currentLocation.neighbors) {
            System.out.println("- " + neighbor);
        }
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
