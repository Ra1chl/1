package Command;

import Space.*;

import java.util.Scanner;

/**
 * Třída Fight implementuje příkaz pro boj mezi hráčem a nepřítelem.
 */
public class Fight implements Command {
    private Player player;
    private Enemy enemy;

    /**
     * Konstruktor třídy Fight.
     *
     * @param player Hráč, který se účastní boje.
     * @param enemy Nepřítel, se kterým se bojuje.
     */
    public Fight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Provádí boj mezi hráčem a nepřítelem.
     *
     * @return Výsledek boje (např. "Victory!" nebo "Game Over!").
     */
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour health: " + player.getHealth());
            System.out.println(enemy.getName() + " health: " + enemy.getHealth());

            // Hráč útočí
            player.attack(enemy);
            if (!enemy.isAlive()) {
                System.out.println("You defeated " + enemy.getName() + "!");
                return "Victory!";
            }

            // Nepřítel útočí
            player.takeDamage(enemy.getAttackPower());
            if (!player.isAlive()) {
                System.out.println("You have been defeated...");
                return "Game Over!";
            }
        }
        return "Fight over.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
