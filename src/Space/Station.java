package Space;

import java.util.ArrayList;

public class Station extends Location{

    public Station(String name,String info,String typeOfItem,String typeOfNPC, ArrayList<String> neighbors) {
        super(name,info,typeOfItem,typeOfNPC, neighbors);
    }
}
