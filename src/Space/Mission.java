package Space;

public class Mission {
    private int creditsForMission;
    private String description;
    private String typeOfMission;

    public Mission( String description,int creditsForMission, String typeOfMission) {
        this.creditsForMission = creditsForMission;
        this.description = description;
        this.typeOfMission = typeOfMission;
    }

    public void startMission(Mission mission) {
        //types of missions
    }

    public String getTypeOfMission() {
        return typeOfMission;
    }

    public void setTypeOfMission(String typeOfMission) {
        this.typeOfMission = typeOfMission;
    }

    public int getCreditsForMission() {
        return creditsForMission;
    }

    public void setCreditsForMission(int creditsForMission) {
        this.creditsForMission = creditsForMission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
