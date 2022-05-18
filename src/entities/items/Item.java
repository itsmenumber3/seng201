package entities.items;

import assets.enums.EntityType;
import assets.enums.ItemType;
import assets.enums.RoleType;
import entities.Entity;
import exceptions.UnallowedMethodException;
import main.Role;

/**
 * Item is an abstract class to from which classes food, potion, and weaponry items can inherit from.
 * This abstract class extends another abstract class, Entity.
 */
public abstract class Item extends Entity {

    // LIBRARIES -------------------------------------------------

    // Inherits MagicNumbers and Tools from superclass Entity

    // LIBRARIES -------------------------------------------------



    // INSTANTIATION ----------------------------------------------

    /**
     * Basic instantiation
     */
    public Item() {
        super();
    }

    /**
     * This method - to instantiate an Item object - does two things:
     * 1. It accepts all the necessary arguments in order to instantiate all the variables as required in Entity.
     * 2. As in the Entity object that this class inherits, it sets entityType to ITEM to denote that this is an item.
     * @param inputEntityName String, custom name of the item
     * @param inputEntityRarity String
     * @param inputEntityPurchaseValue int
     * @param inputEntitySellValue int
     */
    public Item(String inputEntityName, int inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue) {
        super(inputEntityName, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.setEntityType(EntityType.ITEM); // set Entity type that is an ITEM indeed.
    }

    // INSTANTIATION ----------------------------------------------



    // ITEM TYPE --------------------------------------------------

    /**
     * ItemType (enum) can be either Consumable, Fuel, LottoTicket
     */
    public ItemType itemType;

    public void setItemType(ItemType inputItemType) {
        this.itemType = inputItemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    // ITEM TYPE --------------------------------------------------

    private int itemQuantity;

    /**
     * It is not possible for anyone except the shop to set the quantity of an item (we don't want cheating!)
     * If implementing for a shop, use shopSetItemQuantity(int inputItemQuantity, Role inputActor). This method must be exercised by the shop!
     * If implementing for the inventory, use refillItemQuantity(int inputRefillItemQuantity, Role inputActor). This method must be exercised by the player, in their inventory!
     * To reset
     * @param inputItemQuantity integer, this will be discarded!
     */
    public void setItemQuantity(int inputItemQuantity) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method allows a shop to set item quantity before it is sold. Only the shop can do this!
     * @param inputItemQuantity
     * @param inputActor
     */
    public void shopSetItemQuantity(int inputItemQuantity, Role inputActor) {
        try {
            if (inputActor.getRoleType() == RoleType.SHOP) {
                this.itemQuantity = inputItemQuantity;
            } else {
                throw new UnallowedMethodException("Unallowed method");
            }
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public void refillItemQuantity(int inputRefillItemQuantity, Role inputActor) {
        try {
            if (inputActor.getRoleType() == RoleType.PLAYER) {
                this.itemQuantity += inputRefillItemQuantity;
            } else {
                throw new UnallowedMethodException("Unallowed method!");
            }
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public void resetItemQuantity() {
        this.itemQuantity = magicNumbers.RESET_ITEM_QUANTITY;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }
}
