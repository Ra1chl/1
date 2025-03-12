package Command;

public class Info implements Command {

    public String execute() {
        System.out.println("move => move around the map \n" +
                "inventory => show inventory \n" +
                "quit => end game \n" +
                "shop => sell your goodes\n" +
                "");
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
