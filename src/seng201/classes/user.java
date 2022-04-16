/**
 * Main user class
 */

package seng201.classes;

public class user {
    public String userName;
    public int difficultyLevel;

    public int userDays;
    public int currentDay;

    public int userPoint;
    public int userGold;

    public inventory userInventory;

    user() {

    }

    /**
     * Fetch difficulty level
     * @return difficulty level, of type integer
     */

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * setUserDay allows user to set how many days the game will last
     * The maximum number of days is 10, the minimum number of days is 1
     * Anything outside of this range, an ArithmeticException will be thrown
     * @param inputUserDay
     * @throws an ArithmeticException if an invalid day range is entered
     */
    
    public void setUserDays(int inputUserDays) {
        if (inputUserDays <= 10 && inputUserDays >= 1) {
            userDays = inputUserDays;
        } else {
            throw new ArithmeticException("Invalid game days - please choose between 1 and 10 inclusive.");
        }
    }

    /**
     * Return the number of days
     * @return 
     */

    public int getUserDays() { return userDays; }

    /**
     * Start the next day, or end game
     */

    public void startNextDay() {
        if (currentDay >= getUserDays()) {
            endGame(true);
        } else {
            currentDay++;
        }
    }

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

    /**
     * @return the gold balance of the user
     */

    public int getUserGold() {
        return this.userGold;
    }

    /**
     * Set a new gold balance for the user
     * @param newUserGold
     */

    public void setUserGold(int newUserGold) {
        this.userGold = newUserGold;
    }

    /**
     * This function allows the user to purchase an item from the shop
     */

    public void purchase(item purchasingItem) {
        if (this.getUserGold() >= purchasingItem.getValue()) {
            System.out.println("Purchased item successfully");
            this.setUserGold(this.getUserGold() - purchasingItem.getValue());
            userInventory.addToInventory(purchasingItem);
        } else {
            System.out.println("Insufficient gold...");
        }
    }

    public void useWeapon() {
        
    }
}
