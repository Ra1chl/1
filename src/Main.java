import Command.Move;
import Space.LoadMap;
import Space.Location;
import Space.Movement;
import Space.Game;

public class Main {
    public static void main(String[] args) {
        LoadMap loader = new LoadMap();
        if (!loader.loadMap()) {
            System.out.println("Chyba při načítání mapy!");
            return;
        }

        // Nastavení startovní lokace
        Location startLocation = loader.findLocation("ship");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return;
        }

        Game game = new Game(startLocation);
        Move moveCommand = new Move(game, loader);

        Console c = new Console(game, loader, moveCommand);
        c.start();

    }
}