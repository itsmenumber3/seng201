package main;

import assets.enums.RoleType;
import assets.libraries.MagicNumbers;
import assets.libraries.Tools;
import entities.Entity;
import entities.monsters.Monster;
import exceptions.InsufficientPlayerGoldBalanceException;
import exceptions.InvalidInputException;
import exceptions.UnallowedMethodException;
import exceptions.UnexpectedNegativeNumberException;

import java.util.ArrayList;

/**
 *
 */
public class Player implements Role {

    // LIBRARIES --------------------------------------------------

    /**
     * MagicNumbers is a class that holds all constants in this game programme.
     */
    MagicNumbers magicNumbers = new MagicNumbers();
    // Some numerical values are dependent on the difficulty level chosen by the player.
    // magicNumbers will be assigned again when difficulty level is known.

    Tools tools = new Tools(); // Tools is a class that provides some basic functionalities, such as playerName validation
    // and random number generator!

    // LIBRARIES --------------------------------------------------


    // GET ROLE TYPE

    @Override
    public RoleType getRoleType() {
        return RoleType.PLAYER;
    }




    // USERNAME----------------------------------------------------

    private String playerName;

    /**
     * This method accepts a string and set playerName to that string. There are many conditions to a valid playerName:
     * 1. The playerName length must be 5-13 characters inclusive.
     * 2. The playerName must only contain alphanumeric characters.
     * This method tries to assign the input playerName to playerName via the method playerNameValidation as in Tools().
     * If it is invalid, tools.playerNameValidation will throw the error InvalidInputException and will not assign.
     * @param inputPlayerName: String, player-chosen playerName
     */
    public void setPlayerName(String inputPlayerName) {
        try {
            // If playerName does not meet criteria, playerNameValidation will throw an InvalidInputException
            // Else, playerNameValidation returns that exact inputPlayerName: String.
            this.playerName = tools.nameValidation(inputPlayerName);
        }
        catch (InvalidInputException e) { // If playerNameValidation throws this error
            System.out.println("Name not valid");
            this.setPlayerName(tools.readPlayerStringInput("Please enter player name: "));
        }
    }

    /**
     * This method returns the playerName of the player
     * @return playerName: String
     */
    public String getPlayerName() {
        return this.playerName;
    }

    // USERNAME----------------------------------------------------



    // DIFFICULTY----------------------------------------------------

    private int playerDifficulty; // difficulty is an enum type. Defined in Difficulty.java and has three values: EASY, MEDIUM, HARD

    /**
     * This method sets the difficulty level.
     * Difficulty is an enum class defined in Difficulty.java
     * There can be three Difficulty values: EASY, MEDIUM and HARD.
     * @param inputPlayerDifficulty: Difficulty
     */
    public void setPlayerDifficulty(int inputPlayerDifficulty) {
        try {  // Should throw an error if inputPlayerDifficulty is an invalid value.
            if (inputPlayerDifficulty >= 1 && inputPlayerDifficulty <= 3) {
                this.playerDifficulty = inputPlayerDifficulty;
            } else {
                throw new InvalidInputException("Invalid input");
            }
        } catch (InvalidInputException e) {
            System.out.println("Please provide a valid difficulty level");
            e.printStackTrace();
        }
    }

    /**
     * This method returns the difficulty level.
     * @return playerDifficulty: Difficulty
     */
    public int getPlayerDifficulty() {
        return this.playerDifficulty;
    }

    // DIFFICULTY----------------------------------------------------



    // DAYS OF THE GAME----------------------------------------------

    private int playerDays;

    /**
     * This method allows player to set how many days the game will last
     * The maximum number and minimum number of days is set in MagicNumbers().
     * Anything outside this range, an InvalidInputException will be thrown
     * @param inputPlayerDays integer, from player input
     */
    public void setPlayerDays(int inputPlayerDays) {
        try { // If the day is out of the valid range, throw an error.
            if (inputPlayerDays < magicNumbers.MINIMUM_USER_DAYS || inputPlayerDays > magicNumbers.MAXIMUM_USER_DAYS) {
                throw new InvalidInputException(String.format(
                        "The game must have at least %d day(s) and at maximum %d day(s) inclusive.",
                        magicNumbers.MINIMUM_USER_DAYS, magicNumbers.MAXIMUM_USER_DAYS
                ));
            } else { // If not violated, assign
                this.playerDays = inputPlayerDays;
            }
        } catch (InvalidInputException e) { // Catch the error if it occurs.
            this.setPlayerDays(Integer.parseInt(tools.readPlayerStringInput("Enter player days: ")));
        }
    }

    /**
     * This method returns the chosen number of days
     * @return the chosen number of days of type int
     */
    public int getPlayerDays() {
        return this.playerDays;
    }

    // DAYS OF THE GAME----------------------------------------------



    // CURRENT DAY OF THE GAME --------------------------------------

    private int playerCurrentDay;

    /**
     * It is not possible to set the current day, as we want to avoid jumping days.
     * To set the next day, use setNextDay() which increments playerCurrentDay.
     * To reset, use resetCurrentDay() to reset it to 1.
     * @param inputPlayerCurrentDay: integer
     */
    public void setPlayerCurrentDay(int inputPlayerCurrentDay) {
        try { // This method is simply not allowed, so throw an error straight away
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method resets the current day to MagicNumbers.RESET_CURRENT_DAY_VALUE (which should be 0)
     */
    public void resetPlayerCurrentDay() {
        this.playerCurrentDay = magicNumbers.RESET_CURRENT_DAY_VALUE; // Should be 0
    }

    /**
     * This method checks if the player has won the game. This is done by comparing the current day to what is the last day.
     * If the player has won the game, return true to Game(). Else, we increment the playerCurrentDay and return false.
     * @return true:  boolean if player has won the game (the current day is the last day)
     *         false: boolean if player hasn't won the game
     */
    public boolean hasPlayerWonGameElseSetPlayerNextDay() {
        if (this.getPlayerCurrentDay() == this.getPlayerDays()) { // Player has won the game
            return true; // Return true to Game() to conclude the game
        } else { // If Player has not won game
            this.playerCurrentDay++; // Increment to the next day
            return false; // Return false to Game() to start the next day
        }
    }

    /**
     * This method gets the current day and returns it
     * @return playerCurrentDay: integer
     */
    public int getPlayerCurrentDay() {
        return this.playerCurrentDay;
    }

    // CURRENT DAY OF THE GAME --------------------------------------



    // USER POINTS --------------------------------------------------

    public int playerPoints;

    /**
     * Modifying the playerPoints directly is not allowed.
     * @param inputPlayerPoints: integer
     */
    public void setPlayerPoints(int inputPlayerPoints) {
        try {
            throw new UnallowedMethodException("This method is not allowed.");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will reset the player points to zero.
     */
    public void resetPlayerPoint() { this.playerPoints = 0; }

    /**
     * This method increments the player point. Must pass a non-negative integer argument!
     * Throws an error if a negative integer is passed.
     * @param inputIncrementAmount: integer
     */
    public void incrementPlayerPointsBy(int inputIncrementAmount) {
        try {
            if (inputIncrementAmount >= 0) { // Check if this is indeed a non-negative number.
                this.playerPoints = this.getPlayerPoints() + inputIncrementAmount; // Increment player point if correct number.
            } else { // If violated, throw an error.
                throw new UnexpectedNegativeNumberException("Cannot increment player points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method decrements the player points by an amount. Must pass a positive integer as argument!
     * @param inputDecrementAmount: integer
     */
    public void decrementPlayerPointsBy(int inputDecrementAmount) {
        try {
            if (inputDecrementAmount >= 0) { // Check if this is indeed a non-negative number.
                this.playerPoints = this.getPlayerPoints() - inputDecrementAmount; // Decrement if correct number.
            } else { // If violated, throw an error.
                throw new UnexpectedNegativeNumberException("Cannot decrement player points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the player points
     * @return playerPoints: integer
     */
    public int getPlayerPoints() {
        return this.playerPoints;
    }

    // USER POINTS --------------------------------------------------



    // USER GOLDS ---------------------------------------------------

    private int playerGold;

    /**
     * Setting a new gold balance for the player isn't allowed.
     * @param newPlayerGold: integer
     */
    public void setPlayerGold(int newPlayerGold) {
        try { throw new UnallowedMethodException("Method is not allowed"); }
        catch (UnallowedMethodException e) { e.printStackTrace(); }
    }

    /**
     * This method resets the gold balance to zero.
     */
    public void resetPlayerGold() { this.playerGold = 0; }

    /**
     * This method increments player golds. Only accepts a positive integer as argument.
     * @param inputIncrementAmount: integer
     */
    public void incrementPlayerGoldBy(int inputIncrementAmount) {
        try {
            if (inputIncrementAmount >= 0) { this.playerGold = this.playerGold + inputIncrementAmount; }
            else { throw new UnexpectedNegativeNumberException("Cannot accept a negative number"); }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method decrements player golds. Only accepts a positive integer.
     * @param inputDecrementAmount: integer
     */
    public void decrementPlayerGoldBy(int inputDecrementAmount) {
        try {
            if (inputDecrementAmount >= 0) { this.playerGold = this.playerGold - inputDecrementAmount; }
            else { throw new UnexpectedNegativeNumberException("Cannot accept a negative number"); }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the gold balance of the player
     * @return the gold balance of the player
     */
    public int getPlayerGold() { return this.playerGold; }

    // USER GOLDS ---------------------------------------------------



    // USER INVENTORY -----------------------------------------------


    private final Inventory playerInventory = new Inventory(); // PLEASE NOTE THAT there is a main.Inventory() class.
                                                             // this is a constant and will never change.

    /**
     * This method returns the object that is the inventory of the player.
     * WARNING: it returns the object rather than the ArrayList main.Inventory.entities.items;
     * To return only the ArrayList, use main.Inventory().getItems;
     * @return the object playerInventory of type main.Inventory;
     */
    public Inventory getPlayerInventory() { return this.playerInventory; }

    /**
     * Setting playerInventory is not allowed. To add a new item, drop an item, or reset inventory, use
     * main.Inventory().addToInventory(item), .removeFromInventory(item), and .resetInventory()
     * @param inputPlayerInventory: Inventory
     */
    public void setPlayerInventory(Inventory inputPlayerInventory) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        }
        catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method helps the player to purchase an item.
     * 1. Add that item to array list playerInventory.entities.items.
     * 2. Decrement player gold balance.
     * If there isn't enough gold, throw an error InsufficientPlayerGoldBalanceException.
     * @param inputItem: Item, as in Item.java
     */
    public boolean hasPlayerGotEnoughGoldToPurchase(Entity inputEntity) {
        if (this.getPlayerGold() >= inputEntity.getEntityPurchaseValue()) {
            return true;
        } else {
            return false;
        }
    }

    public void playerPurchaseEntity(Entity inputEntity) {
        try {
            if (this.hasPlayerGotEnoughGoldToPurchase(inputEntity)) {
                System.out.println("Purchased successfully");  // If yes, purchased successfully.
                this.decrementPlayerGoldBy(inputEntity.getEntityPurchaseValue()); // Decrement playerGold.
                playerInventory.addToInventory(inputEntity);
            } else {
                throw new InsufficientPlayerGoldBalanceException("Not enough gold");
            }
        } catch (InsufficientPlayerGoldBalanceException e) {
            e.printStackTrace();
        }
    }

    // INVENTORY ----------------------------------------------------
}
