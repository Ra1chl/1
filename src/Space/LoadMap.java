package Space;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadMap {

    public ArrayList<Location> map = new ArrayList<>();
    private HashMap<String, Location> locations = new HashMap<>(); // Pro rychlé vyhledávání lokací

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
            String line;

            // 1. Nejprve vytvoříme všechny lokace, ale ještě je nepropojujeme
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 2) continue; // Ochrana proti chybným řádkům

                String name = parts[0].trim();
                String info = parts[1].trim();
                ArrayList<String> neighbors = new ArrayList<>();

                for (int i = 2; i < parts.length; i++) {
                    neighbors.add(parts[i].trim()); // Uložíme jména sousedů
                }

                Location location = createLocation(name, info, neighbors);
                if (location != null) {
                    locations.put(name, location);
                    map.add(location);
                }
            }

            // 2. Propojení lokací podle seznamu sousedů
            for (Location loc : map) {
                ArrayList<String> neighbors = loc.neighbors; // Seznam sousedních jmen
                loc.neighbors = new ArrayList<>(); // Vyčistíme, protože teď uložíme objekty

                for (String neighborName : neighbors) {
                    Location neighbor = locations.get(neighborName);
                    if (neighbor != null) {
                        loc.neighbors.add(neighbor.name); // Přidáme propojení
                    }
                }
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Location createLocation(String name, String info, ArrayList<String> neighbors) {
        switch (name.toLowerCase()) {
            case "ship": return new Ship(name, info, neighbors);
            case "planeta": return new PlanetA(name, info, neighbors);
            case "planetb": return new PlanetB(name, info, neighbors);
            case "planetc": return new PlanetC(name, info, neighbors);
            case "station": return new Station(name, info, neighbors);
            case "asteroid": return new Asteroid(name, info, neighbors);
            case "bandit": return new Bandit(name, info, neighbors);
            case "hangar": return new Hangar(name, info, neighbors);
            default: return null; // Pokud název neodpovídá žádné třídě, vrátíme null
        }
    }
}
