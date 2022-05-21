package main;

import java.util.ArrayList; //

import assets.enums.DrinkType;
import assets.enums.FoodType;
import assets.enums.RoleType;
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import entities.monsters.Monster;

/**
 * The class Shop provides for a shop where a player can come to trade.
 * Please refer to our documentation.
 * @author Francis
 */
public class Shop implements Role {
	

    /**
     * This method returns the RoleType of the shop, which is SHOP.
     * @return value SHOP of enum type RoleType.
     */
    @Override
    public RoleType getRoleType() {
        return RoleType.SHOP;
    }

    /**
     * Shop
     */
    private String shopName;
    
    public void setShopName(String inputShopName) {
    	this.shopName = inputShopName;
    }
    
    public String getShopName() {
    	return this.shopName;
    }

    /**
     * The ArrayList shopRange contains a list of entities for sale on a particular day.
     */
    private ArrayList<Monster> shopMonsterRange;


    //private final ArrayList<Monster> monstersWhichPlayerPurchasedToday = new ArrayList<>();

    /**
     * This method isn't allowed. Instead, use one of the following methods:
     * (1) addEntityToShopMonsterRange and removeEntityFromShopMonsterRange.
     * (2) stockEntity and dailyShopMonsterRangeRefresh.
     * @param inputShopMonsterRange ArrayList<Monster>
     */
    public void setShopMonsterRange(ArrayList<Monster> inputShopMonsterRange) {
    	this.shopMonsterRange = inputShopMonsterRange;
    }

    /**
     * This method returns the current shopRange.
     * @return shopRange ArrayList<Monster>
     */
    public ArrayList<Monster> getShopMonsterRange() {
        return this.shopMonsterRange;
    }

    /**
     * This method removes an entity from the shop range.
     * @param inputEntity Entity
     */
    private void removeMonsterFromShopMonsterRange(Monster removeMonster) {
        this.getShopMonsterRange().remove(removeMonster); // Remove it from the shop range
    }

    /**
     * This method triggers relevant methods when an entity is purchased from the shop by the player.
     * @param inputEntity Entity, the entity in question
     */
    public void uponMonsterBeingPurchasedByPlayer(Monster inputMonster) {
        this.removeMonsterFromShopMonsterRange(inputMonster);
        
    }


    
    private ArrayList<Food> shopFoodRange;
    
    public void setShopFoodRange() {
    	Food apple = new Food(FoodType.APPLE);
    	Food pasta = new Food(FoodType.PASTA);
    	this.shopFoodRange.add(apple);
    	this.shopFoodRange.add(pasta);
    }

    /**
     * This method returns the current shopRange.
     * @return shopRange ArrayList<Monster>
     */
    public ArrayList<Food> getShopFoodRange() {
        return this.shopFoodRange;
    }
    
    private ArrayList<Drink> shopDrinkRange;
    
    public void setShopDrinkRange() {
    	Drink coffee = new Drink(DrinkType.COFFEE);
    	Drink energyDrink = new Drink(DrinkType.ENERGY_DRINKS);
    	this.shopDrinkRange.add(coffee);
    	this.shopDrinkRange.add(energyDrink);
    }

    /**
     * This method returns the current shopRange.
     * @return shopRange ArrayList<Monster>
     */
    public ArrayList<Drink> getShopDrinkRange() {
        return this.shopDrinkRange;
    }
    
}
