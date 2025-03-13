package Command;

import Space.Game;

public class Info implements Command {
    private Game game;

    public Info(Game game) {
        this.game = game;
    }

    public String execute() {

        return game.read("cominfo.txt");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
