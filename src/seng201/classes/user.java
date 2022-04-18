/**
 * Main user class concerning the player of the game Monster Fighter.
 * It stores data about the player and has functions for a user to control the game by co-ordinating other methods.
 * Author: Francis Phan
 */

package seng201.classes;

public class user {

    magicNumbers magicNumbers = new magicNumbers();

    // VARIABLES AND THEIR GETTERS AND SETTERS

    /**
     * userName stores the name of the user, as input in GUI.
     */
    private String userName;

    /** 
     * setUserName accepts a string and set userName to that string
     * The username must be of 5 characters or longer, of 13 characters or shorter, and must not contain " "
     * @param getUserName of type string
     * @throws InvalidInputException if the input does not satisfy the above conditions
     */
    public void setUserName(String inputUserName) throws InvalidInputException { 
        if (inputUserName.contains(magicNumbers.UNALLOWED_USERNAME_CHARACTER)) {
            throw new InvalidInputException("Username must not contain white spaces");
        } 
        if (inputUserName.length() <= 13 && inputUserName.length() >= 5) {
            this.userName = inputUserName; 
        } else if (inputUserName.length() > 13) {
            throw new InvalidInputException("Name is too long, it should be");
        }  else {
            throw new InvalidInputException("Name is too short");
        }
    }

    /**
     * getUserName returns the userName of the user
     * @return userName
     */
    public String getUserName() { return this.userName; }



    /**
     * This variable stores the difficulty level of the game, as input by user.
     * difficulty is an enum type. It is defined in difficulty.java and has three values: EASY, MEDIUM, HARD
     */
    private difficulty difficultyLevel;

    /**
     * This method sets the difficulty level
     * @param difficulty level of enum type difficulty
     */
    public void setDifficultyLevel(difficulty inputDifficultyLevel) { this.difficultyLevel = inputDifficultyLevel; }

    /**
     * this method returns the difficulty level.
     * @return difficulty level of enum type difficulty
     */
    public difficulty getDifficultyLevel() { return difficultyLevel; }



    /**
     * This variable stores the chosen length of the game, measured in days.
     */
    private int userDays;

    /**
     * setUserDay allows user to set how many days the game will last
     * The maximum number of days is 10, the minimum number of days is 1
     * Anything outside of this range, an ArithmeticException will be thrown
     * @param inputUserDay
     * @throws an ArithmeticException if an invalid day range is entered
     */
    public void setUserDays(int inputUserDays) {
        if (inputUserDays <= magicNumbers.MAXIMUM_USER_DAYS && inputUserDays >= 1) {
            userDays = inputUserDays;
        } else {
            throw new ArithmeticException("Invalid game days - please choose between 1 and 10 inclusive.");
        }
    }

    /**
     * This method returns the chosen number of days
     * @return the chosen number of days of type int
     */
    public int getUserDays(int inputUserDays) { return userDays; }



    /**
     * This method returns the current day of the days
     * The first day is Day 1.
     */
    private int currentDay;

    public int getCurrentDay() {
        return this.currentDay;
    }

    public void setCurrentDay(int currentDay) {
        System.out.println("DEVELOPER WARNING: You must use setNextDay() instead");
    }

    public void setNextDay() {
        if (this.getCurrentDay() == this.getUserDays()) {
            // User has won the game? Redirect to method endGame
            this.endGame(true);
        } else {
            this.currentDay++; // Increment to the next day
            // Start the next day, supposedly?
            this.startNextDay();
        }
    }

    /**
     * This variable stores the point of the user.
     */

    public int userPoint;
    public int userGold;

    public inventory userInventory;

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
}
