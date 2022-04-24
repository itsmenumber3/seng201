package entities.items;

import assets.enums.EntityType;
import assets.enums.ItemType;
import assets.enums.Rarity;
import assets.enums.RoleType;
import entities.*;
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
     * This method - to instantiate an Item object - does two things:
     * 1. It accepts all the necessary parameters in order to instantiate all the variables as required in Entity.
     * 2. It sets entityType to ITEM to denote that this is an item.
     * @param inputEntityName
     * @param inputEntityDescription
     * @param inputEntityRarity
     * @param inputEntityPurchaseValue
     * @param inputEntitySellValue
     * @param inputItemQuantity
     */
    public Item(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue) {
        super(inputEntityName, inputEntityDescription, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.setEntityType(EntityType.ITEM); // set Entity type that is an ITEM indeed.
    }

    // INSTANTIATION ----------------------------------------------



    // ITEM TYPE --------------------------------------------------

    public ItemType itemType;

    public void setItemType(ItemType inputItemType) {
        this.itemType = inputItemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    // ITEM TYPE --------------------------------------------------

    private int itemQuantity;

    public void setItemQuantity(int inputItemQuantity, Role inputActor) {
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

    public void refillItemQuantity(int inputRefillItemQuantity) {
        this.itemQuantity += inputRefillItemQuantity;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }
}
