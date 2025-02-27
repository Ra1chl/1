import Space.LoadMap;
import Space.Location;

public class Main {
    public static void main(String[] args) {
        LoadMap loader = new LoadMap();
        if (loader.loadMap()) {
            System.out.println("Mapa načtena úspěšně!");

            for (Location loc : loader.map) {
                System.out.println(loc.name + " -> " + loc.neighbors);
            }
        } else {
            System.out.println("Chyba při načítání mapy.");
        }

    }
}