package Space;

import javax.tools.JavaFileManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadMap {

    public ArrayList<Space.Location> map;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
            String line;
            ArrayList<String> namesOfLoc = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");

                for (int i = 2; i < lines.length; i++) {
                    namesOfLoc.add(lines[i]);
                }

                switch (lines[0]) {
                    case "asteroid":
                        Asteroid asteroid = new Asteroid(lines[0],lines[1], namesOfLoc);
                        break;

                    case "bandit":
                        Bandit bandit = new Bandit(lines[0],lines[1], namesOfLoc);
                        break;

                    case "hangar":
                        Hangar hangar = new Hangar(lines[0],lines[1], namesOfLoc);
                        break;

                    case "planetA":
                        PlanetA planetA = new PlanetA(lines[0],lines[1], namesOfLoc);
                        break;

                    case "planetB":
                        PlanetB planetB = new PlanetB(lines[0],lines[1], namesOfLoc);
                        break;

                    case "planetC":
                        PlanetC planetC = new PlanetC(lines[0],lines[1], namesOfLoc);

                        break;
                    case "ship":
                        Ship ship = new Ship(lines[0],lines[1], namesOfLoc);
                        break;

                    case "station":
                        Station station = new Station(lines[0],lines[1], namesOfLoc);
                        break;

                }

            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }

}
