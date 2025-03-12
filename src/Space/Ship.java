package Space;

import java.util.ArrayList;

public class Ship extends Location{
    public Ship(String name,String info,String typeOfItem,String typeOfNPC, ArrayList<String> neighbors) {
        super(name,info, typeOfItem, typeOfNPC, neighbors);
    }
}
