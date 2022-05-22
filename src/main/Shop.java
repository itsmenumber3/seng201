package main;


import java.util.ArrayList;

import assets.enums.RoleType;
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

    // -- DELETE -- CHECK IF SAFE
    
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

    
}
