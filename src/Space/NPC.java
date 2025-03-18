package Space;

public class NPC {
    private String name;
    private String role;
private Mission mission;
private boolean bad; //je zly nebo hodbny

    public NPC(String name, String role) {
        this.name = name;
        this.role = role;// Např. "obchodník", "pašerák", "nepřítel"
    }

    public void interact(String nameOfNPC) {
        switch (nameOfNPC) {
            case "mechanic":
                Mission mission1 = new Mission("NEW PARTS", 50,"\"I need 5 gray stones form asteroid rain!\"");
                mission.startMission(mission1);
                break;
            case "bandit":
                Mission mission2 = new Mission("STEAL PLANS",500,"Steal main plans from your manager");
                mission.startMission(mission2);
                break;
            case "manager":
                Mission mission3 = new Mission("JUST GO",500,"Manage need money, go mine yellow,blue and red stone");
                mission.startMission(mission3);
                break;

                default:
                    break;
        }
    }
}
