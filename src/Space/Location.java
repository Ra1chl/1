package Space;

import java.util.ArrayList;

public abstract class Location {

    public String name;
    public String info;
    protected ArrayList<String> neighbors;

    public Location(String name,String info, ArrayList<String> neighbors) {
        this.name = name;
        this.info = info;
        this.neighbors = neighbors;
    }

}
