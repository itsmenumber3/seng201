package main;

import assets.enums.EntityType;
import assets.enums.ItemType;
import assets.enums.RoleType;
import entities.*;
import entities.items.weapons.Weapon;
import exceptions.UnallowedMethodException;
import java.util.ArrayList; //

/**
 * The class Shop provides for a shop where a player can come to trade.
 * They can purchase new entities from the shop, and sell their entities to the shop.
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
     * The ArrayList shopRange contains a list of entities for sale on a particular day.
     */
    private final ArrayList<Entity> shopRange = new ArrayList<>();

    private final ArrayList<Entity> whatPlayerPurchasedToday = new ArrayList<>();

    /**
     * This method isn't allowed. Instead, use one of the following methods:
     * (1) addEntityToShopRange and removeEntityFromShopRange.
     * (2) stockEntity and dailyShopRangeRefresh.
     * @param inputShopRange ArrayList<Entity>
     */
    public void setShopRange(ArrayList<Entity> inputShopRange) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the current shopRange.
     * @return shopRange ArrayList<Entity>
     */
    public ArrayList<Entity> getShopRange() {
        return this.shopRange;
    }

    /**
     * This method manually adds an entity to shopRange.
     * @param inputEntity Entity, entity to be added to range
     */
    public void addEntityToShopRange(Entity inputEntity) {
        this.shopRange.add(inputEntity);
    }

    /**
     * This method triggers relevant methods when an entity is purchased from the shop by the player.
     * @param inputEntity Entity, the entity in question
     */
    public void uponEntityBeingPurchasedByPlayer(Entity inputEntity) {
        this.removeEntityFromShopRange(inputEntity);
    }

    /**
     * This method triggers relevant methods when an entity is sold by the player to the shop.
     * @param inputEntity Entity, the entity in question
     */
    public void uponEntityBeingSoldToShop(Entity inputEntity) {
        this.addEntityToShopRange(inputEntity);
    }

    /**
     * This method removes an entity from the shop range.
     * @param inputEntity Entity
     */
    public void removeEntityFromShopRange(Entity inputEntity) {
        this.getShopRange().remove(inputEntity); // Remove it from the shop range
    }

    /**
     * This method refreshes a shop range by:
     * 1. Randomly removing an entity, such as a food item.
     * 2. Replacing that entity with a new entity of the same EntityType but with some changes in variables and price.
     * 3. Stock new entities of the same EntityType that the user bought the previous day.
     * This refresh should only happen overnight.
     */
    public void overnightRefreshShopRange() {

    }
}
