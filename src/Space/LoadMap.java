package Space;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadMap {

    public ArrayList<Location> map = new ArrayList<>();
    private HashMap<String, Location> locations;

    public LoadMap() {
        locations = new HashMap<>();
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
            String line;

            // 1. Nejprve vytvoříme všechny lokace, ale ještě je nepropojujeme
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String name = parts[0].trim();
                String info = parts[1].trim();
                String item = parts[2].trim();
                String npc = parts[3].trim();

                ArrayList<String> neighbors = new ArrayList<>();

                for (int i = 4; i < parts.length; i++) {
                    neighbors.add(parts[i].trim()); // Uložíme jména sousedů
                }

                Location location = createLocation(name, info,item,npc, neighbors);
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

    private Location createLocation(String name, String info, String item, String npc, ArrayList<String> neighbors) {
        switch (name.toLowerCase()) {
            case "ship": return new Ship(name, info,item,npc, neighbors);
            case "planeta": return new PlanetA(name, info,item,npc, neighbors);
            case "planetb": return new PlanetB(name, info,item,npc, neighbors);
            case "planetc": return new PlanetC(name, info,item,npc, neighbors);
            case "station": return new Station(name, info,item,npc, neighbors);
            case "asteroid": return new Asteroid(name, info,item,npc, neighbors);
            case "bandit": return new Bandit(name, info,item,npc, neighbors);
            case "hangar": return new Hangar(name, info,item,npc, neighbors);
            default: return null; // Pokud název neodpovídá žádné třídě, vrátíme null
        }
    }

    public Location findLocation(String name) {
        for (Location loc : map) {
            if (loc.name.equalsIgnoreCase(name)) {
                return loc;
            }
        }
        return null;
    }

}
