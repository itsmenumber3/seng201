package main;

import assets.enums.FoodType;
import assets.libraries.Tools;
import entities.items.LottoTicket;
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
	
	// LIBRARIES --------------------------------------------------
	/**
     * Tools is a class that provides some basic functionalities, such as howManyMonstersBasedOnDifficulty
     */
    Tools tools = new Tools();
    // LIBRARIES --------------------------------------------------
    
    
    private Player player; // Used to set the player of the game
    private ArrayList<Monster> monsters = new ArrayList<>(); // An ArrayList for holding objects of Monster type.
    private HashMap<Food, Integer> foods = new HashMap<>(); // A HashMap for holding the quantity of each Food type.
    private HashMap<Drink, Integer> drinks = new HashMap<>(); // A HashMap for holding the quantity of each Drink type.
    private double fuelAmount; // A double for holding the quantity of fuel owned
    private LottoTicket lottoTicket = null; // A lotto ticket is required to increase the chances of a random event happpening during travel
    
    // CONSTRUCTOR ------------------------------------------------
    /**
     * Constructor for the inventory class
     * @param inputPlayer
     */
    public Inventory(Player inputPlayer) {
        player = inputPlayer;
        resetFoods();
        resetDrinks();
        resetMonsters();
        resetLottoTicket();
    }
    // CONSTRUCTOR ------------------------------------------------

    // MONSTERS ---------------------------------------------------
    /**
     * Resets the ArrayList of monsters
     */
    private void resetMonsters() {
        monsters = new ArrayList<>();
    }

    /**
     * This method is not allowed.
     * Setting a custom list of monster is not permitted
     * @param inputMonsters ArrayList<Monster>
     */
    public void setMonsters(ArrayList<Monster> inputMonsters) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the current list of monsters that the player owns
     * @return monsters ArrayList<Monster>
     */
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    /**
     * Adds a new monster to the list of monsters
     * If the player still has space available in their team the monster is added
     * @param inputMonster Monster
     * @return true boolean, If there is enough space on the team for another monster
     * 	false boolean, If there is not enough space on the team for another monster
     */
    public boolean addMonster(Monster inputMonster) {
    	if (monsters.size() >= tools.howManyMonstersBasedOnDifficulty(player.getPlayerDifficulty())) {
    		return false;
    	} else {
            getMonsters().add(inputMonster);
            return true;
    	}
    }
    // MONSTERS ---------------------------------------------------

    // FOOD -------------------------------------------------------
    /**
     * This method resets the food HashMap
     */
    public void resetFoods() {
        foods = new HashMap<>();
        foods.put(player.getFoodRange()[0], 0);
        foods.put(player.getFoodRange()[1], 0);
    }

    /**
     * This method is not allowed.
     * Setting a custom list of food is not permitted
     * @throws UnallowedMethodException
     */
    public void setFoods(HashMap<Drink, Integer> inputFoods) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add an item of food to the HashMap mapping 
     * the player now has 1 more quantity of the specified food
     * @param inputFood Food
     */
    public void addFood(Food inputFood) {
        foods.put(inputFood, foods.get(inputFood) + 1);
    }

    /**
     * Remove an item of food from the HashMap mapping
     * the player now has 1 less quantity of the specified food
     * @param inputFood Food
     */
    public void removeFood(Food inputFood) {
        foods.put(inputFood, foods.get(inputFood) - 1);
    }

    /**
     * This method returns the HashMap of food options
     * @return foods HashMap
     */
    public HashMap<Food, Integer> getFoods() {
        return foods;
    }
    // FOOD -------------------------------------------------------

    // DRINKS -----------------------------------------------------
    /**
     * This method resets the drink HashMap
     */
    public void resetDrinks() {
        drinks = new HashMap<>();
        drinks.put(player.getDrinkRange()[0], 0);
        drinks.put(player.getDrinkRange()[1], 0);
    }

    /**
     * This method is not allowed.
     * Setting a custom list of food is not permitted
     * @throws UnallowedMethodException
     */
    public void setDrinks(HashMap<Drink, Integer> inputDrinks) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add an item of drink to the HashMap mapping 
     * the player now has 1 more quantity of the specified drink
     * @param inputDrink Drink
     */
    public void addDrink(Drink inputDrink) {
        drinks.put(inputDrink, foods.get(inputDrink) + 1);
    }
    /**
     * Remove an item of drink from the HashMap mapping
     * the player now has 1 less quantity of the specified drink
     * @param inputDrink Drink
     */
    public void removeDrink(Drink inputDrink) {
        drinks.put(inputDrink, foods.get(inputDrink) - 1);
    }
    
    /**
     * This method returns the HashMap of drink options
     * @return drinks HashMap
     */
    public HashMap<Drink, Integer> getDrinks() {
        return drinks;
    }
    // DRINKS -----------------------------------------------------
    
    // FUEL -------------------------------------------------------
    /**
     * Resets the amount of fuel to the default starting value of 50
     */
    public void resetFuelAmount() {
        fuelAmount = 50;
    }

    /**
     * Get the current amount of fuel that the player owns
     * @return fuelAmount double
     */
    public double getFuelAmount() {
        return fuelAmount;
    }

    /**
     * Increases the quantity of fuel owned
     * @param inputRefillAmount double
     */
    public void refillFuel(double inputRefillAmount) {
        fuelAmount += inputRefillAmount;
    }
    
    /**
     * This method is not allowed.
     * Setting a custom amount of fuel is not permitted
     * @param inputFuel double
     * @throws UnallowedMethodException
     */
    public void setFuelAmount(double inputFuel) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Checks to see if there is enough fuel to travel from one location to the next
     * @param inputFuelAmount double
     * @return true boolean, If there is enough fuel it is removed from the quantity owned
     * 	false boolean, If there is not enough fuel the team cannot travel
     */
    public boolean hasEnoughFuelIfTrueUseFuel(double inputFuelAmount) {
    	if (inputFuelAmount >= fuelAmount) {
    		fuelAmount -= inputFuelAmount;
    		return true;
    	} else {
    		return false;
    	}
    }
    // FUEL -------------------------------------------------------

    // LOTTO TICKET -----------------------------------------------
    /**
     * Adds a lotto ticket to the players inventory 
     * A lotto ticket increases the chance of a random activity happening during travel
     * @param inputLottoTicket
     */
    public void setLottoTicket(LottoTicket inputLottoTicket) {
        lottoTicket = inputLottoTicket;
    }

    /**
     * Gets the current lotto ticket from the inventory
     * @return lottoTicket LottoTicket
     */
    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    /**
     * Resets the lotto ticket inventory so that a new one must be purchased
     */
    public void resetLottoTicket() {
        lottoTicket = null;
    }
    // LOTTO TICKET -----------------------------------------------

}