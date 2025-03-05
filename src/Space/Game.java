package Space;

public class Game {
    private Location currentLocation;

    public Game(Location startingLocation) {
        this.currentLocation = startingLocation;
    }


    public boolean moveTo(Location destination) {
        if (currentLocation.canMoveTo(destination.name)) {
            currentLocation = destination;
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
