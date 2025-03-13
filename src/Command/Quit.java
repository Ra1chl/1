package Command;

public class Quit implements Command {

    @Override
    public String execute() {
        System.exit(0);
        return "the end";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
