package main;

import assets.enums.EntityType;
import assets.enums.ItemType;
import assets.enums.RoleType;
import entities.*;
import entities.items.weapons.Weapon;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;
import java.util.ArrayList; //

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
     * The ArrayList shopRange contains a list of entities for sale on a particular day.
     */
    private final ArrayList<Monster> shopMonsterRange = new ArrayList<>();


    private final ArrayList<Monster> monstersWhichPlayerPurchasedToday = new ArrayList<>();

    /**
     * This method isn't allowed. Instead, use one of the following methods:
     * (1) addEntityToShopMonsterRange and removeEntityFromShopMonsterRange.
     * (2) stockEntity and dailyShopMonsterRangeRefresh.
     * @param inputShopMonsterRange ArrayList<Monster>
     */
    public void setShopMonsterRange(ArrayList<Monster> inputShopMonsterRange) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the current shopRange.
     * @return shopRange ArrayList<Monster>
     */
    public ArrayList<Monster> getShopMonsterRange() {
        return this.shopMonsterRange;
    }

    /**
     * This method manually adds an entity to shopRange.
     * @param inputEntity Entity, entity to be added to range
     */
    private void addMonsterToShopMonsterRange(Monster inputMonster) {
        this.getShopMonsterRange().add(inputMonster);
    }

    /**
     * This method removes an entity from the shop range.
     * @param inputEntity Entity
     */
    private void removeMonsterFromShopMonsterRange(Monster removeMonster) {
        this.getShopMonsterRange().remove(inputEntity); // Remove it from the shop range
    }

    /**
     * This method triggers relevant methods when an entity is purchased from the shop by the player.
     * @param inputEntity Entity, the entity in question
     */
    public void uponMonsterBeingPurchasedByPlayer(Monster inputMonster) {
        this.removeMonsterFromShopMonsterRange(inputMonster);
        this.
    }

    /**
     * This method triggers relevant methods when an entity is sold by the player to the shop.
     * @param inputEntity Entity, the entity in question
     */
    public void uponEntityBeingSoldToShop(Entity inputEntity) {
        this.addEntityToShopMonsterRange(inputEntity);
    }


    /**
     * This method refreshes the monster range of a shop by:
     * 1. For existing stock,
     */
    public void overnightRefreshShopMonsterRange() {

    }
}
