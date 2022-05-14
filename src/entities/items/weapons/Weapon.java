package entities.items.weapons;

import assets.enums.ItemType;
import assets.enums.Rarity;
import assets.enums.WeaponType;
import entities.items.Item;

public abstract class Weapon extends Item {

    // INSTANTIATION ------------------------------------------

    /**
     * This method - to instantiate a Weapon object - does three things:
     * 1. It accepts all the necessary arguments in order to instantiate an Item object. This Item object in turns accept these arguments to instantiate an Entity object.
     * 2. As in the Item object that this class inherits, upon initialised, entityType is set to ITEM to denote that this is an item.
     * 3. As for this class which inherits from Item, upon initialised, itemType is set to WEAPON to denote that this is a weapon.
     * @param inputEntityName String the
     * @param inputEntityRarity
     * @param inputEntityPurchaseValue
     * @param inputEntitySellValue
     */
    public Weapon(String inputEntityName, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue) {
        super(inputEntityName, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.setItemType(ItemType.WEAPON);
    }

    // INSTANTIATION ------------------------------------------

    public WeaponType weaponType;

    public void setWeaponType(WeaponType inputWeaponType) {
        this.weaponType = inputWeaponType;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }
}
