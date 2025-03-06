package Space;

import java.util.Scanner;

public class Movement {
    private Game game;
    private LoadMap loader;

    public Movement(Game game, LoadMap loader) {
        this.game = game;
        this.loader = loader;
    }

    public Movement() {

    }

    public void startMovement() {
        Scanner scanner = new Scanner(System.in);

         while (true) {
            System.out.println("\nJsi na lokaci: " + game.getCurrentLocation().name);
            System.out.println(game.getCurrentLocation().info);
            game.showAvailableMoves();

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

            game.moveTo(destination);
        }

        scanner.close();
    }


}
