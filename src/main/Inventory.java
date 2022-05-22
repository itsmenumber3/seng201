package main;

import assets.libraries.Tools;
import entities.items.LottoTicket;
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import entities.monsters.Monster;
import exceptions.InvalidInputException;
import exceptions.UnallowedMethodException;

import java.util.ArrayList;

public class Inventory {

    Player player;
    Tools tools = new Tools();

    public Inventory(Player inputPlayer) {
        this.player = inputPlayer;
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

    public boolean removeMonster(int index) {
        try {
            if (index >= getMonsters().size()) {
                throw new InvalidInputException();
            } else {
                getMonsters().remove(index);
            }
        } catch (InvalidInputException e) {

        }
    }


    // ARRAY LIST TO HOLD MONSTERS --------------------------------
    
    // Please reimplement - separate array lists for food, drinks, lotto, and fuel.

    // ARRAY LIST TO HOLD ITEMS --------------------------------

    /**
     * This is an ArrayList holding objects of Entity type.
     */
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * This method resets the inventory i.e. a blank ArrayList
     */
    public void resetFoods() {
        this.foods = new ArrayList<>();
    }

    /**
     * This method, to set a custom arraylist to the arraylist entities, isn't allowed.
     * Using it will throw an error.
     *
     * @see UnallowedMethodException
     */
    public void setFoods() {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the ArrayList entities
     *
     * @return this.entities: ArrayList
     */
    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public void addToFoods(Food inputFood) {
        this.foods.add(inputFood);
    }

    private ArrayList<Drink> drinks = new ArrayList<>();

    public void resetDrinks() {
        drinks = new ArrayList<>();
    }

    public void setDrinks(ArrayList<Drink> inputDrinks) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void addDrink(Drink inputDrink) {
        drinks.add(inputDrink);
    }

    public void removeDrink(Drink inputDrink) {
        drinks.remove(inputDrink);
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


