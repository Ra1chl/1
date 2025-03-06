package Space;

public class Game {
    private Location currentLocation;

    public Game() {

    }



    public Game(Location startingLocation) {
        this.currentLocation = startingLocation;
    }

    public void startGame (){
        LoadMap loader = new LoadMap();
        if (!loader.loadMap()) {
            System.out.println("Chyba při načítání mapy!");
            return;
        }
        // Najdeme startovní lokaci (například Ship)
        Location startLocation = loader.findLocation("ship");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return;
        }
        Game game = new Game(startLocation);
        Movement movement = new Movement(game, loader);

        // Spustíme pohybovou logiku
        //movement.startMovement();
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
