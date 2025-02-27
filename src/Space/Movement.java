package Space;

import java.util.Scanner;

public class Movement {
    private Player player;
    private LoadMap loader;

    public Movement(Player player, LoadMap loader) {
        this.player = player;
        this.loader = loader;
    }

    public void startMovement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nJsi na lokaci: " + player.getCurrentLocation().name);
            System.out.println(player.getCurrentLocation().info);
            player.showAvailableMoves();

            System.out.print("Kam chceš jít? (napiš název lokace nebo 'exit' pro ukončení): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Hra ukončena.");
                break;
            }

            Location destination = loader.findLocation(input);
            if (destination == null) {
                System.out.println("Tato lokace neexistuje!");
                continue;
            }

            player.moveTo(destination);
        }

        scanner.close();
    }
}
