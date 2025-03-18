package Command;

import Space.*;

import java.util.Scanner;

public class Fight implements Command {
    private Player player;
    private Enemy enemy;

    public Fight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

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
