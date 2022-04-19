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

public class user {

    MagicNumbers magicNumbers = new MagicNumbers();
    Tools tools = new Tools();

    // USERNAME----------------------------------------------------

    private String userName;

    /** 
     * setUserName accepts a string and set userName to that string
     * The username must be of 5 characters or longer, of 13 characters or shorter, and must not contain " "
     * @param getUserName of type string
     * @throws InvalidInputException if the input does not satisfy the above conditions
     */
    public void setUserName(String inputUserName) throws InvalidInputException { 
        if (tools.IsUserNameValid(inputUserName) == true) {
            this.userName = inputUserName;
        } else {
            throw new InvalidInputException("Invalid username");
        }
    }

    /**
     * getUserName returns the userName of the user
     * @return userName
     */
    public String getUserName() { return this.userName; }

    // USERNAME----------------------------------------------------



    // DIFFICULTY----------------------------------------------------

    private Difficulty difficultyLevel; // difficulty is an enum type. Defined in Difficulty.java and has three values: EASY, MEDIUM, HARD

    /**
     * This method sets the difficulty level
     * @param difficulty level of enum type difficulty
     */
    public void setDifficultyLevel(Difficulty inputDifficultyLevel) { this.difficultyLevel = inputDifficultyLevel; }

    /**
     * this method returns the difficulty level.
     * @return difficulty level of enum type difficulty
     */
    public Difficulty getDifficultyLevel() { return difficultyLevel; }

    // DIFFICULTY----------------------------------------------------



    // DAYS OF THE GAME----------------------------------------------

    private int userDays;

    /**
     * setUserDay allows user to set how many days the game will last
     * The maximum number of days is 10, the minimum number of days is 1
     * Anything outside of this range, an ArithmeticException will be thrown
     * @param inputUserDay
     * @throws an ArithmeticException if an invalid day range is entered
     */
    public void setUserDays(int inputUserDays) {
        if (inputUserDays <= magicNumbers.MAXIMUM_USER_DAYS && inputUserDays >= magicNumbers.MINIMUM_USER_DAYS) {
            userDays = inputUserDays;
        } else {
            throw new ArithmeticException(magicNumbers.INVALID_USER_DAYS_ERROR_MESSAGE);
        }
    }

    /**
     * This method returns the chosen number of days
     * @return the chosen number of days of type int
     */
    public int getUserDays(int inputUserDays) { return this.userDays; }

    // DAYS OF THE GAME----------------------------------------------



    // CURRENT DAY OF THE GAME --------------------------------------

    private int currentDay;

    /**
     * This method will get the current day and return it
     * @return the current day
     */
    public int getCurrentDay() { return this.currentDay; }

    /**
     * It is not possible to set the current day. Safe programming practices.
     * @param currentDay
     * @throws an an error
     */
    public void setCurrentDay(int currentDay) throws UnallowedMethodException { 
        throw new UnallowedMethodException("You must use setNextDay() instead"); 
    }

    /**
     * This method sets the next day of the game.
     */
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
     * Start the next day, or end game
     */
    public void startNextDay() {
        if (currentDay >= getUserDays()) {
            endGame(true);
        } else {
            currentDay++;
        }
    }

    // CURRENT DAY OF THE GAME --------------------------------------

    

    // USER POINTS --------------------------------------------------

    public int userPoints;

    /**
     * This method returns the user points
     * @return the user points
     */
    public int getUserPoints() { return this.userPoints; }

    /**
     * Modifying the userpoint directly is not allowed.
     * @param inputUserPoints
     * @throws an error
     */
    public void setUserPoints(int inputUserPoints) throws UnallowedMethodException { 
        throw new UnallowedMethodException("This method is not allowed."); 
    }

    /**
     * This method will reset the user points to zero.
     */
    public void resetUserPoint() { this.userPoints = 0; }

    /**
     * This method accepts a positive integer only, to increase user points.
     * @param inputIncrementAmount
     */
    public void incrementUserPointsBy(int inputIncrementAmount) throws InvalidInputException {
        if (inputIncrementAmount >= 0) {
            this.userPoints = this.getUserPoints() + inputIncrementAmount;
        } else {
            throw new InvalidInputException("Cannot increment user points by a negative number.");
        }
    }

    /**
     * This method accepts a positive integer only, to DECREASE user points.
     * @param inputDecrementAmount
     */
    public void decrementUserPointsBy(int inputDecrementAmount) throws InvalidInputException {
        if (inputDecrementAmount >= 0 ) {
            this.userPoints = this.getUserPoints() - inputDecrementAmount;
        } else {
            throw new InvalidInputException("Enter a positive number to decrease by.");
        }
        
    }

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
    public void setUserInventory(Inventory inputUserInventory) throws UnallowedMethodException { 
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
