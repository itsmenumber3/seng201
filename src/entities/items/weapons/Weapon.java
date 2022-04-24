package entities.items.weapons;

import assets.enums.Rarity;
import entities.items.Item;

public abstract class Weapon extends Item {

    public Weapon(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue, int inputItemQuantity) {
        super(inputEntityName, inputEntityDescription, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue, inputItemQuantity);
    }
}
