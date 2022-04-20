package seng201;

import java.io.Console;


public class Game {

    Console console = System.console();

    public Game() {
        this.welcomeScreen();
    }

    public void welcomeScreen() {
        System.out.println("Welcome to Monster Fighter");
        console.readLine("Press any key to start game [ANY KEY]: ");
    }

    // END THE GAME -------------------------------------------------

    public static void main(String[] args) {
        Game game = new Game();
    }

    
}
