import Space.LoadMap;
import Space.Location;
import Space.Movement;
import Space.Game;

public class Main {
    public static void main(String[] args) {

        
        Game game = new Game();
        game.startGame();

        Console c = new Console();
        c.start();

    }
}