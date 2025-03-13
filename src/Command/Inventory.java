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
        return "To je vše!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
