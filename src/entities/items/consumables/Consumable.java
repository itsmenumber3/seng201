package entities.items.consumables;

import assets.enums.ConsumableType;
import assets.enums.ItemType;
import assets.enums.Rarity;
import entities.items.Item;

/**
 * The interface Consumable provides for a blueprint to implement the classes food and potion.
 * @see Food
 * @see Potion
 */
public class Consumable extends Item {
    Consumable(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue) {
        super(inputEntityName, inputEntityDescription, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.setItemType(ItemType.CONSUMABLE);
    }

    /**
     * This variable holds the type
     */
    public ConsumableType consumableType;

    public void setConsumableType(ConsumableType inputConsumableType) {
        this.consumableType = inputConsumableType;
    }

    public ConsumableType getConsumableType() {
        return this.consumableType;
    }
}
