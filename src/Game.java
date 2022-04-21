import main.*; // Import Inventory and Shop
import assets.*; // Import MagicNumbers and Tools
import exceptions.*; // Import the Exception classes
import items.*; // Import items that player can buy and hold
import monsters.*; // Import monsters that player can buy and hold

public class Game {
    public Game() {
        Player player = new Player();
    }
    public static void main(String[] args) {
        Game game = new Game();
    }
}
