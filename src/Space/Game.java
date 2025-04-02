package Space;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Třída Game představuje hlavní herní logiku.
 * Spravuje hráče a aktuální lokaci.
 */
public class Game {
    private Player player;
    private Location currentLocation;

    /**
     * Konstruktor pro inicializaci hry.
     * @param startingLocation Výchozí lokace hry.
     * @param player Hráč ve hře.
     */
    public Game(Location startingLocation, Player player) {
        this.currentLocation = startingLocation;
        this.player = player;
    }

    /**
     * Vrátí hráče.
     * @return Instance hráče.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Spustí hru, načte mapu a nastaví startovní lokaci.
     */
    public void startGame() {
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
        Game game = new Game(startLocation, player);

        // Spustíme pohybovou logiku
        //movement.startMovement();
    }

    /**
     * Přesune hráče do nové lokace, pokud je pohyb možný.
     * @param destination Cílová lokace.
     * @return True, pokud byl pohyb úspěšný, jinak false.
     */
    public boolean moveTo(Location destination) {
        if (currentLocation.canMoveTo(destination.name)) {
            currentLocation = destination;
            return true;
        } else {
            System.out.println("Nemůžeš se tam přesunout!");
            return false;
        }
    }

    /**
     * Zobrazí dostupné pohyby do sousedních lokací.
     */
    public void showAvailableMoves() {
        System.out.println("Můžeš se přesunout na:");
        for (String neighbor : currentLocation.neighbors) {
            System.out.println("- " + neighbor);
        }
    }

    /**
     * Načte obsah souboru a vypíše ho do konzole.
     * @param file Název souboru k načtení.
     * @return Obsah souboru jako String.
     */
    public String read(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
