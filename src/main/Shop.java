package main;


import java.util.ArrayList;

import assets.enums.RoleType;
import entities.monsters.Monster;

/**
 * The class Shop provides for a shop where a player can come to trade.
 */
public class Shop implements Role {
	
    private String shopName; // The shop name that is based off the location the player is currently at
    private ArrayList<Monster> shopMonsterRange; // The ArrayList shopRange contains a list of entities for sale on a particular day.
    
	// GET ROLE TYPE ----------------------------------------------
    /**
     * This method returns the RoleType of the shop, which is SHOP.
     * @return value SHOP of enum type RoleType.
     */
    @Override
    public RoleType getRoleType() {
        return RoleType.SHOP;
    }
    // GET ROLE TYPE ----------------------------------------------
    
    // SHOP NAME --------------------------------------------------
    /**
     * Sets the shop name based on the location that the team is in
     * @param inputShopName String
     */
    public void setShopName(String inputShopName) {
    	shopName = inputShopName;
    }
    
    /**
     * Gets the shop name for displaying in the shop and map screen
     * @return shopName String
     */
    public String getShopName() {
    	return shopName;
    }
    // SHOP NAME --------------------------------------------------

    // MONSTER RANGE ----------------------------------------------
    /**
     * This method isn't allowed. 
     * Instead, use one of the following methods:
     * (1) addEntityToShopMonsterRange and removeEntityFromShopMonsterRange.
     * (2) stockEntity and dailyShopMonsterRangeRefresh.
     * @param inputShopMonsterRange ArrayList<Monster>
     */
    public void setShopMonsterRange(ArrayList<Monster> inputShopMonsterRange) {
    	shopMonsterRange = inputShopMonsterRange;
    }

    /**
     * This method returns the current shop range of monsters
     * @return shopMonsterRange ArrayList<Monster>
     */
    public ArrayList<Monster> getShopMonsterRange() {
        return shopMonsterRange;
    }

    // MONSTER RANGE ----------------------------------------------  
}
