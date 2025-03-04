package Space;

import java.util.Scanner;

public class Movement {
    private Move move;
    private LoadMap loader;

    public Movement(Move move, LoadMap loader) {
        this.move = move;
        this.loader = loader;
    }

    public void startMovement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nJsi na lokaci: " + move.getCurrentLocation().name);
            System.out.println(move.getCurrentLocation().info);
            move.showAvailableMoves();

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

            move.moveTo(destination);
        }

        scanner.close();
    }
}
