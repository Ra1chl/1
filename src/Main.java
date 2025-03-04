import Space.LoadMap;
import Space.Location;
import Space.Movement;
import Space.Move;

public class Main {
    public static void main(String[] args) {
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

        Move move = new Move(startLocation);
        Movement movement = new Movement(move, loader);

        // Spustíme pohybovou logiku
        movement.startMovement();

    }
}