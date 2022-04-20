package seng201;

public class Game {

    // END THE GAME -------------------------------------------------

    /** 
     * This function ends the game.
     * @param boolean to indicate if user has won
     */

    public void endGame(boolean hasUserWonGame) {
        // Do something
        if (hasUserWonGame == false) {
            System.out.println("Game Over");
        } else {
            System.out.println("You've won!");
        }
    }

    user() {

    }

    /**
     * Fetch difficulty level
     * @return difficulty level, of type integer
     */

    

    

    /**
     * Return the number of days
     * @return 
     */

    public int getUserDays() { return userDays; }



    

    private boolean isGamePaused;

    public boolean getIsGamePaused() {
        return this.isGamePaused;
    }

    /**
     * This method will allow the user to pause and unpause the game. 
     */

    public void togglePauseUnpauseGame() {
        this.isGamePaused = !(this.getIsGamePaused()); // Negate it!

        if (this.getIsGamePaused() == true) {
            System.out.println("Game has been paused");
        } else {
            System.out.println("Game has been resumed");
        }
        
    }

    public int randomNumber;

    private Random randomSeed = new Random();

    public void randomiser() {
        randomNumber = randomSeed.nextInt(20);
    }
    
    public static void main(String[] args) {
        
    }

    
}
