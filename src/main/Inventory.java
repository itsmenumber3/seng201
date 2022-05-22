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

    Player player;
    Tools tools = new Tools();

    public Inventory(Player inputPlayer) {
        this.player = inputPlayer;
        resetFoods();
        resetDrinks();
        resetMonsters();
        resetLottoTicket();
    }

    // ARRAY LIST TO HOLD MONSTERS --------------------------------

    private ArrayList<Monster> monsters = new ArrayList<>();

    private void resetMonsters() {
        this.monsters = new ArrayList<>();
    }

    public void setMonsters(ArrayList<Monster> inputMonsters) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    public boolean addMonster(Monster inputMonster) {
    	if (monsters.size() >= tools.howManyMonstersBasedOnDifficulty(player.getPlayerDifficulty())) {
    		return false;
    	} else {
            getMonsters().add(inputMonster);
            return true;
    	}
    }




    // ARRAY LIST TO HOLD MONSTERS --------------------------------
    
    // Please reimplement - separate array lists for food, drinks, lotto, and fuel.

    // ARRAY LIST TO HOLD ITEMS --------------------------------

    /**
     * This is an ArrayList holding objects of Entity type.
     */
    private HashMap<Food, Integer> foods = new HashMap<>();

    /**
     * This method resets the inventory i.e. a blank ArrayList
     */
    public void resetFoods() {
        this.foods = new HashMap<>();
        foods.put(player.getFoodRange().get(0), 0);
        foods.put(player.getFoodRange().get(1), 0);
    }

    /**
     * This method, to set a custom arraylist to the arraylist entities, isn't allowed.
     * Using it will throw an error.
     *
     * @see UnallowedMethodException
     */
    public void setFoods(HashMap<Drink, Integer> inputFoods) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public void addFood(Food inputFood) {
        foods.put(inputFood, foods.get(inputFood) + 1);
    }

    public void removeFood(Food inputFood) {
        foods.put(inputFood, foods.get(inputFood) - 1);
    }

    /**
     * This method returns the ArrayList entities
     *
     * @return this.entities: ArrayList
     */
    public HashMap<Food, Integer> getFoods() {
        return this.foods;
    }

    private HashMap<Drink, Integer> drinks = new HashMap<>();

    public void resetDrinks() {
        drinks = new HashMap<>();
        drinks.put(player.getDrinkRange().get(0), 0);
        drinks.put(player.getDrinkRange().get(1), 0);
    }

    public void setDrinks(HashMap<Drink, Integer> inputDrinks) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Drink, Integer> getDrinks() {
        return drinks;
    }

    public void addDrink(Drink inputDrink) {
        drinks.put(inputDrink, foods.get(inputDrink) + 1);
    }

    public void removeDrink(Drink inputDrink) {
        drinks.put(inputDrink, foods.get(inputDrink) - 1);
    }

    private double fuelAmount;
    
    public void setFuelAmount(double inputFuel) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void refillFuel(double inputRefillAmount) {
        this.fuelAmount += inputRefillAmount;
    }

    public void resetFuelAmount() {
        fuelAmount = 50;
    }

    private LottoTicket lottoTicket = null;

    public void setLottoTicket(LottoTicket inputLottoTicket) {
        lottoTicket = inputLottoTicket;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public void resetLottoTicket() {
        lottoTicket = null;
    }
    
    public boolean hasEnoughFuelIfTrueUseFuel(double inputFuelAmount) {
    	if (inputFuelAmount >= fuelAmount) {
    		fuelAmount -= inputFuelAmount;
    		return true;
    	} else {
    		return false;
    	}
    }
}

    // ARRAY LIST TO HOLD ENTITIES --------------------------------



    // ADD AN ENTITY OBJECT INTO THE ARRAY LIST -------------------

    /**
     * All entities can be stored in an inventory but the way they should be added is different depending on
     * This method adds an entity to the arraylist above if it's a monster - regardless of they are the same or different.
     *
     * For items, we have to check first if an identical item has already existed in the inventory. If yes, update the quantity.
     * If such an item doesn't exist, then simply add that entity.
     * For example, if there are already tunas in the inventory, and the player purchases new tunas, update the quantity.
     * But if they buy lamb, then add to the arraylist.
     * @param inputEntity: Entity
     */


    // ADD AN ENTITY OBJECT INTO THE ARRAY LIST -------------------



    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------


    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------



    // IF AN ENTITY RUNS OUT OF ALL THE UNITS IT HAS --------------


