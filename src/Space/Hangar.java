package Space;

import java.util.ArrayList;

public class Hangar extends Location{
    public Hangar(String name,String info,String typeOfItem,String typeOfNPC, ArrayList<String> neighbors) {
        super(name, info,typeOfNPC,typeOfItem, neighbors);
    }
}
