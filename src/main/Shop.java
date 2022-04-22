package main;

import entities.*;
import exceptions.UnallowedMethodException;

import java.util.ArrayList;

/**
 * The class Shop provides for a shop where a player can come to trade.
 * They can purchase new entities from the shop, and sell their entities to the shop.
 * @author Francis
 */
public class Shop implements Role {

    /**
     * The ArrayList shopRange contains a list of entities for sale on a particular day.
     */
    private final ArrayList<Entity> shopRange = new ArrayList<>();

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
     * This
     * @param inputEntity
     */
    public void removeEntityFromShopRange(Entity inputEntity) {}

    public void randomStockEntity() {

    }

    public void randomUpdateExistingEntity() {

    }

    /**
     * This function refreshes the entity range of the product at the beginning of each day by a random factor.
     */
    public void dailyShopRangeRefresh() {

    }
}
