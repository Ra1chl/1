package Command;

import Space.Player;

public class Inventory implements Command {
    private Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.showInventory();
        return "That's all!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
