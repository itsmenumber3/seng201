package entities.items;

import assets.enums.Rarity;
import entities.*;
import exceptions.UnallowedMethodException;

/**
 * Item is an abstract class to from which classes food, potion, and weaponry items can inherit from.
 * This abstract class extends another abstract class, Entity.
 */
public abstract class Item extends Entity {

    public Item(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue,
                int inputItemQuantity) {
        super(inputEntityName, inputEntityDescription, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.se
    }

    private int itemQuantity;

    public void setItemQuantity(int inputItemQuantity) {
        try {
            throw new UnallowedMethodException("Unallowed method");
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
