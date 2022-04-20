/**
 * Main user class concerning the player of the game Monster Fighter.
 * It stores data about the player and has functions for a user to control the game by co-ordinating other methods.
 * Author: Francis Phan
 */

package seng201.classes;

import java.util.*;

import seng201.classes.*;

import seng201.classes.exceptions.*;

import seng201.classes.assets.*;

import seng201.classes.items.*;

public class User {

    MagicNumbers magicNumbers = new MagicNumbers();
    Tools tools = new Tools();

    // USERNAME----------------------------------------------------

    private String userName;

    /** 
     * This method accepts a string and set userName to that string. There are many conditions to a valid username:
     * 1. The username must be of 5 characters or longer, of 13 characters or shorter.
     * 2. The username must only contain alphanumeric characters.
     * This method tries to assign the input username to userName via the method userNameValidation as in Tools().
     * If it is invalid, tools.userNameValidation will throw the error InvalidInputException and will not assign.
     * @param inputUserName: String, user-chosen username
     */
    public void setUserName(String inputUserName) throws InvalidInputException { 
        try { 
            this.userName = tools.userNameValidation(inputUserName); 
        } 
        catch (InvalidInputException e) { e.printStackTrace(); }
    }

    /**
     * This method returns the userName of the user
     * @return userName: String
     */
    public String getUserName() { return this.userName; }

    // USERNAME----------------------------------------------------



    // DIFFICULTY----------------------------------------------------

    private Difficulty difficultyLevel; // difficulty is an enum type. Defined in Difficulty.java and has three values: EASY, MEDIUM, HARD

    /**
     * This method sets the difficulty level.
     * Difficulty is an enum class defined in Difficulty.java
     * There can be three Difficulty values: EASY, MEDIUM and HARD.
     * @param inputDifficultyLevel: Difficulty
     */
    public void setDifficultyLevel(Difficulty inputDifficultyLevel) { 
        try { this.difficultyLevel = inputDifficultyLevel; } 
        catch (Exception e) { e.printStackTrace(); }
    }

    /**
     * This method returns the difficulty level.
     * @return difficultyLevel: Difficulty
     */
    public Difficulty getDifficultyLevel() { return this.difficultyLevel; }

    // DIFFICULTY----------------------------------------------------



    // DAYS OF THE GAME----------------------------------------------

    private int userDays;

    /**
     * This method allows user to set how many days the game will last
     * The maximum number and minimum number of days is set in MagicNumbers().
     * Anything outside of this range, an InvalidInputException will be thrown
     * @param inputUserDay: integer, from user input
     */
    public void setUserDays(int inputUserDays) {
        try { this.userDays = tools.userDaysValidation(inputUserDays); } 
        catch (InvalidInputException e) { e.printStackTrace(); }
    }

    /**
     * This method returns the chosen number of days
     * @return the chosen number of days of type int
     */
    public int getUserDays(int inputUserDays) { return this.userDays; }

    // DAYS OF THE GAME----------------------------------------------



    // CURRENT DAY OF THE GAME --------------------------------------

    private int userCurrentDay;

    /**
     * It is not possible to set the current day, as we want to avoid jumping days.
     * To set the next day, use setNextDay() which increments userCurrentDay.
     * To reset, use resetCurrentDay() to reset it to 1.
     * @param inputCurrentDay: integer
     * @throws UnallowedMethodException
     */
    public void setCurrentDay(int inputCurrentDay) { 
        try { throw new UnallowedMethodException("Unallowed method"); } 
        catch (UnallowedMethodException e) { e.printStackTrace(); }
    }

    /**
     * This method checks if the user has won the game. This is done by comparing the current day to what is the last day.
     * If the user has won the game, return true to Game(). Else, we increment the userCurrentDay and return false.
     * @return true:  boolean if user has won the game (the current day is the last day)
     *         false: boolean if user hasn't won the game 
     */
    public boolean hasUserWonGameElseSetNextDay() {
        if (this.getCurrentDay() == this.getUserDays()) { // User has won the game
            return true; // Return true to Game() to conclude the game
        } else {
            this.userCurrentDay++; // Increment to the next day
            return false; // Return false to Game() to start the next day
        }
    }

    /**
     * This method gets the current day and returns it
     * @return userCurrentDay: integer
     */
    public int getCurrentDay() { return this.userCurrentDay; }

    // CURRENT DAY OF THE GAME --------------------------------------

    

    // USER POINTS --------------------------------------------------

    public int userPoints;

    /**
     * Modifying the userPoints directly is not allowed.
     * @param inputUserPoints: integer
     * @throws UnallowedMethodException
     */
    public void setUserPoints(int inputUserPoints) { 
        try { throw new UnallowedMethodException("This method is not allowed."); }
        catch (UnallowedMethodException e) { e.printStackTrace(); }
    }

    /**
     * This method will reset the user points to zero.
     */
    public void resetUserPoint() { this.userPoints = 0; }

    /**
     * This method increments the user point. Must pass a positive integer argument!
     * @param inputIncrementAmount: integer
     * @throws UnexpectedNegativeNumberException if a negative integer is passed.
     */
    public void incrementUserPointsBy(int inputIncrementAmount) {
        try {
            if (inputIncrementAmount >= 0) {
                this.userPoints = this.getUserPoints() + inputIncrementAmount;
            } else {
                throw new UnexpectedNegativeNumberException("Cannot increment user points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) { 
            e.printStackTrace(); 
        }
    }

    /**
     * This method decrements the user points by an amount. Must pass a positive integer as argument!
     * @param inputDecrementAmount: integer
     */
    public void decrementUserPointsBy(int inputDecrementAmount) throws InvalidInputException {
        try {
            if (inputDecrementAmount >= 0) {
                this.userPoints = this.getUserPoints() - inputDecrementAmount;
            } else {
                throw new UnexpectedNegativeNumberException("Cannot decrement user points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) { 
            e.printStackTrace(); 
        }
    }

        /**
     * This method returns the user points
     * @return the user points
     */
    public int getUserPoints() { return this.userPoints; }

    // USER POINTS --------------------------------------------------



    // USER GOLDS ---------------------------------------------------

    private int userGold;

    /**
     * This method returns the gold balance of the user
     * @return the gold balance of the user
     */
    public int getUserGold() { return this.userGold; }

    /**
     * Setting a new gold balance for the user isn't allowed.
     * @param newUserGold
     * @throws UnallowedMethodException
     */
    public void setUserGold(int newUserGold) throws UnallowedMethodException {
        throw new UnallowedMethodException("Method is not allowed"); 
    }

    /**
     * This method resets the gold balance to zero.
     */
    public void resetUserGold() { this.userGold = 0; }

    /**
     * This method increments user golds. Only accepts a positive integer.
     * @param inputIncrementDecrementAmount
     */
    public void incrementUserGoldBy(int inputIncrementAmount) throws InvalidInputException {
        if (inputIncrementAmount >= 0) { this.userGold = this.userGold + inputIncrementAmount; } 
        else { throw new InvalidInputException("Cannot accept a negative number"); }
    }

    /**
     * This method decrements user golds. Only accepts a positive integer.
     * @param inputDecrementAmount
     */
    public void decrementUserGoldBy(int inputDecrementAmount) {
        try {
            this.userGold = this.userGold - inputDecrementAmount;
        } catch (inputDecrementAmount <= 0) {
            throw new InvalidInputException("Enter a positive number");
        }
        if (inputDecrementAmount >= 0) { ; } 
        else {  }
    }

    // USER GOLDS ---------------------------------------------------



    // USER INVENTORY -----------------------------------------------

    private Inventory userInventory = new Inventory();

    /**
     * This method returns the object that is the inventory of the user.
     * WARNING: it returns the object rather than the ArrayList Inventory.items[];
     * To return only the ArrayList, use Inventory.getItems;
     * @return the object userInventory of type Inventory;
     */
    public Inventory getUserInventory() { return this.userInventory; }

    /**
     * Setting userInventory is not allowed.
     * To add a new item, drop an item, or reset inventory, use
     * Inventory.addToInventory(item), .removeFromInventory(item), resetInventory()
     * @param inputUserInventory
     * @throws UnallowedMethodException
     */
    public void setUserInventory(Inventory inputUserInventory) throws { 
        throw new UnallowedMethodException("Unallowed method"); 
    }

    /**
     * This function allows the user to purchase an item from the shop
     */
    public void userPurchaseItem(Item inputItem) {
        if (this.getUserGold() >= inputItem.getItemValue()) {
            System.out.println("Purchased item successfully");
            this.decrementUserGoldBy(inputItem.getItemValue());
            userInventory.addToInventory(inputItem);
        } else {
            System.out.println("Insufficient gold...");
        }
    }

    // INVENTORY ----------------------------------------------------


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
}
