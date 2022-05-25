package main;

import assets.enums.DrinkType;
import assets.enums.FoodType;
import assets.enums.RoleType;
import assets.libraries.MagicNumbers;

import battles.Battle;
import entities.Entity;
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import exceptions.InvalidInputException;
import exceptions.UnallowedMethodException;
import exceptions.UnexpectedNegativeNumberException;

/**
 * The class player is where all player dependent variables are accessed from
 */
public class Player implements Role {

    // LIBRARIES --------------------------------------------------
    /**
     * MagicNumbers is a class that holds all constants in this game programme.
     */
    private final MagicNumbers magicNumbers = new MagicNumbers();
    // Some numerical values are dependent on the difficulty level chosen by the player.
    // magicNumbers will be assigned again when difficulty level is known.

    /**
     * Tools is a class that provides some basic functionalities, such as playerName validation
     * and random number generator!
     */

    // LIBRARIES --------------------------------------------------

    private String playerName; // Player name that is entered in setup screen
    private int playerDifficulty; // difficulty is an enum type. Defined in Difficulty.java and has three values: EASY, MEDIUM, HARD
    private int playerDays; // Players selected duration that is chosen in set up screen
    private int playerCurrentDay; // Current day for player within game
    private int playerPoints; // Points that the player has accumulated throughout the game
    private int playerGold; // Amount of gold the player has to purchase items and monsters
    private final Inventory playerInventory = new Inventory(this); /* PLEASE NOTE THAT there is a main.Inventory() class.
    	this is a constant and will never change. */
    private Battle playerSelectedBattle; // Current battle location the player is in
    private Battle playerPreviewBattle; // Battle location that player is going to travel to next


    // CONSTRUCTOR ------------------------------------------------
    /**
     * Constructor for player class that default sets the fuel amount to 50
     */
    public Player() {
        playerInventory.resetFuelAmount();
    }
    // CONSTRUCTOR ------------------------------------------------

    // GET ROLE TYPE ----------------------------------------------
    /**
     * Overrides the <code>Role</code> interface and default returns <code>RoleType.PLAYER</code>
     */
    @Override
    public RoleType getRoleType() {
        return RoleType.PLAYER;
    }
    // GET ROLE TYPE ----------------------------------------------

    // USERNAME----------------------------------------------------
    /**
     * This method accepts a string and set <code>playerName</code> to that string. There are many conditions to a valid <code>playerName</code>:
     * 1. The playerName length must be 5-13 characters inclusive.
     * 2. The playerName must only contain alphanumeric characters.
     * This method tries to assign the input playerName to playerName via the method playerNameValidation as in Tools().
     * If it is invalid, tools.playerNameValidation will throw the error InvalidInputException and will not assign.
     * @param inputPlayerName String, player-chosen playerName
     * @return true boolean, if input name meets validation rules
     * 	false boolean, if input name does not meet validation rules
     */
    public boolean setPlayerName(String inputPlayerName) {
        try {
            if (inputPlayerName.length() >=3) {
                playerName = inputPlayerName;
            } else {
                throw new InvalidInputException();
            }

            return true;
        }
        catch (InvalidInputException e) {
            return false;
        }
    }

    /**
     * This method returns the <code>playerName</code> of the player
     * @return playerName String
     */
    public String getPlayerName() {
        return playerName;
    }
    // USERNAME----------------------------------------------------

    // DIFFICULTY--------------------------------------------------
    /**
     * This method sets the difficulty level.
     * There can be three Difficulty values: EASY(1), MEDIUM(2) and HARD(3).
     * It will throw an error if inputPlayerDifficulty is an invalid value.
     * @param inputPlayerDifficulty integer
     * @throws InvalidInputException
     */
    public void setPlayerDifficulty(int inputPlayerDifficulty) {
        try {
            if (inputPlayerDifficulty >= 1 && inputPlayerDifficulty <= 3) {
                playerDifficulty = inputPlayerDifficulty;
            } else {
                throw new InvalidInputException("Invalid input");
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the difficulty level.
     * @return playerDifficulty integer
     */
    public int getPlayerDifficulty() {
        return playerDifficulty;
    }
    // DIFFICULTY--------------------------------------------------

    // DAYS OF THE GAME--------------------------------------------
    /**
     * This method allows player to set how many days the game will last
     * The maximum number and minimum number of days is set in MagicNumbers().
     * Anything outside this range, an InvalidInputException will be thrown
     * @param inputPlayerDays integer, from player input
     * @throws InvalidInputException
     */
    public void setPlayerDays(int inputPlayerDays) {
        try { // If the day is out of the valid range, throw an error.
            if (inputPlayerDays < magicNumbers.MINIMUM_USER_DAYS || inputPlayerDays > magicNumbers.MAXIMUM_USER_DAYS) {
                throw new InvalidInputException(String.format(
                        "The game must have at least %d day(s) and at maximum %d day(s) inclusive.",
                        magicNumbers.MINIMUM_USER_DAYS, magicNumbers.MAXIMUM_USER_DAYS
                ));
            } else { // If not violated, assign
                playerDays = inputPlayerDays;
            }
        } catch (InvalidInputException e) { // Catch the error if it occurs.
            e.printStackTrace(); // Handle it
        }
    }

    /**
     * This method returns the chosen number of days
     * @return playerDays integer, the chosen number of days
     */
    public int getPlayerDays() {
        return playerDays;
    }
    // DAYS OF THE GAME--------------------------------------------

    // CURRENT DAY OF THE GAME ------------------------------------
    /**
     * This method is not allowed.
     * It is not possible to set the current day, as we want to avoid jumping days.
     * To set the next day, use setNextDay() which increments playerCurrentDay.
     * To reset, use resetCurrentDay() to reset it to 1.
     * @param inputPlayerCurrentDay integer
     * @throws UnallowedMethodException
     */
    public void setPlayerCurrentDay(int inputPlayerCurrentDay) {
        try { // This method is simply not allowed, so throw an error straight away
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Checks the current day of the game against the selected duration of the game
     * @return true boolean, if the player has completed the duration of the game
     * 	false boolean, if the player has not reached the selected duration
     */
    public boolean hasGameBeenWon() {
    	if (playerCurrentDay == playerDays) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Change to next day when the player moves to the next battle
     */
    public void setNextDayNextBattle() {
    	playerCurrentDay += 1;
    	playerSelectedBattle = playerPreviewBattle; 
    }

    /**
     * This method resets the current day to MagicNumbers.RESET_CURRENT_DAY_VALUE (which should be 0)
     */
    public void resetPlayerCurrentDay() {
        playerCurrentDay = magicNumbers.RESET_CURRENT_DAY_VALUE;
    }



    /**
     * This method gets the current day and returns it
     * @return playerCurrentDay integer
     */
    public int getPlayerCurrentDay() {
        return playerCurrentDay;
    }
    // CURRENT DAY OF THE GAME ------------------------------------

    // USER POINTS ------------------------------------------------
    /**
     * This method is not allowed.
     * Modifying the playerPoints directly is not possible as we do not want the points to be incremented unreasonably
     * @param inputPlayerPoints integer
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
    public void resetPlayerPoint() { playerPoints = 0; }

    /**
     * This method increments the player points. Must pass a positive integer argument!
     * Throws an error if a negative integer is passed.
     * @param inputIncrementAmount integer
     * @throws UnexpectedNegativeNumberException
     */
    public void incrementPlayerPointsBy(int inputIncrementAmount) {
        try {
            if (inputIncrementAmount >= 0) {
                playerPoints = getPlayerPoints() + inputIncrementAmount;
            } else {
                throw new UnexpectedNegativeNumberException("Cannot increment player points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method decrements the player points by an amount. Must pass a positive integer as argument!
     * @param inputDecrementAmount integer
     * @throws UnexpectedNegativeNumberException
     */
    public void decrementPlayerPointsBy(int inputDecrementAmount) {
        try {
            if (inputDecrementAmount >= 0) {
                playerPoints = getPlayerPoints() - inputDecrementAmount;
            } else {
                throw new UnexpectedNegativeNumberException("Cannot decrement player points by a negative number.");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the player points
     * @return playerPoints integer
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    // USER POINTS ------------------------------------------------

    // USER GOLDS -------------------------------------------------
    /**
     * This method is not allowed.
     * Setting a new gold balance for the player is not possible as we do not want the players gold incremented unreasonably
     * @param newPlayerGold integer
     */
    public void setPlayerGold(int newPlayerGold) {
        try { throw new UnallowedMethodException("Method is not allowed"); }
        catch (UnallowedMethodException e) { e.printStackTrace(); }
    }

    /**
     * This method resets the gold balance to zero.
     */
    public void resetPlayerGold() { playerGold = 0; }

    /**
     * This method increments player golds. Only accepts a positive integer as argument.
     * @param inputIncrementAmount integer
     * @throws UnexpectedNegativeNumberException
     */
    public void incrementPlayerGoldBy(int inputIncrementAmount) {
        try {
            if (inputIncrementAmount >= 0) { playerGold = playerGold + inputIncrementAmount; }
            else { throw new UnexpectedNegativeNumberException("Cannot accept a negative number"); }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method decrements player golds. Only accepts a positive integer.
     * @param inputDecrementAmount integer
     * @throws UnexpectedNegativeNumberException
     */
    public void decrementPlayerGoldBy(int inputDecrementAmount) {
        try {
            if (inputDecrementAmount >= 0) { playerGold = playerGold - inputDecrementAmount; }
            else { throw new UnexpectedNegativeNumberException("Cannot accept a negative number"); }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the gold balance of the player
     * @return playerGold integer, the gold balance of the player
     */
    public int getPlayerGold() { return playerGold; }

    // USER GOLDS -------------------------------------------------

    // USER INVENTORY ---------------------------------------------
    /**
     * This method returns the object that is the inventory of the player.
     * WARNING: it returns the object rather than the ArrayList main.Inventory.entities.items;
     * To return only the ArrayList, use main.Inventory().getItems;
     * @return playerInventory Inventory
     */
    public Inventory getPlayerInventory() { return playerInventory; }

    /**
     * Setting playerInventory is not allowed. To add a new item, remove an item, or reset inventory, use
     * main.Inventory().addToInventory(item), .removeFromInventory(item), and .resetInventory()
     * @param inputPlayerInventory Inventory
     * @throws UnallowedMethodException
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
     * Checks whether the player can purchase the selected entity(monster or item) given the amount of gold they have
     * @param inputEntity Entity
     * @return successStatus boolean, whether the player has enough gold to purchase the item 
     * 		and the amount has been remove from the players gold balance
     */
    public boolean playerPurchaseEntity(Entity inputEntity) {
    	boolean successStatus = getPlayerGold() >= inputEntity.getEntityPurchaseValue();
    	if (successStatus) {
    		decrementPlayerGoldBy(inputEntity.getEntityPurchaseValue()); // Decrement playerGold.
    	} 
    	return successStatus;
    }
    // INVENTORY --------------------------------------------------
    
    // SELECTED BATTLE --------------------------------------------
    /**
     * Sets the selected battle location that the player is visiting
     * @param inputPlayerSelectedBattle Battle
     */
    public void setPlayerSelectedBattle(Battle inputPlayerSelectedBattle) {
    	playerSelectedBattle = inputPlayerSelectedBattle;
    }
    
    /**
     * Gets the location of the battle that the player is at
     * @return playerSelectedBattle Battle
     */
    public Battle getPlayerSelectedBattle() {
    	return playerSelectedBattle;
    }
    // SELECTED BATTLE --------------------------------------------
    
    // PREVIEW BATTLE ---------------------------------------------
    /**
     * Sets the battle location that the player needs to confirm they are visiting.
     * Used for creation of battle screen and changes to the selected battle when they travel
     * @param inputBattle Battle
     */
    public void setPlayerPreviewBattle(Battle inputBattle) {
    	playerPreviewBattle = inputBattle;
    }
    
    /**
     * Gets the location of the battle the player is previewing to visit next
     * @return playerPreviewBattle Battle
     */
    public Battle getPlayerPreviewBattle() {
    	return playerPreviewBattle;
    }
    
    /**
     * Makes the changes required when traveling to the next battle location
     * The required fuel amount is checked that it is available and if so then it is removed from the players inventory
     * @return true boolean, If the player has enough fuel they can proceed to travel to the next battle location
     *	false boolean, If the player does not have enough fuel they will be reverted.
     *	where they can go to the shop and buy more fuel
     */
    public boolean travelToPreviewBattle() {
    	int fuelAmountNeeded;
    	if (playerSelectedBattle.getBattleIsland() == playerPreviewBattle.getBattleIsland()) {
    		fuelAmountNeeded = 10;
    	} else {
    		fuelAmountNeeded = 20;
    	}
    	if (getPlayerInventory().hasEnoughFuelIfTrueUseFuel(fuelAmountNeeded)) {
    		setNextDayNextBattle();
    		return true;
    	} else {
    		return false;
    	}
    }
    // PREVIEW BATTLE ---------------------------------------------

    public Food[] getFoodRange() {
        return new Food[] {new Food(FoodType.APPLE), new Food(FoodType.PASTA)};
    }

    public Drink[] getDrinkRange() {
        return new Drink[] {new Drink(DrinkType.COFFEE), new Drink(DrinkType.ENERGY_DRINK)};
    }
}
