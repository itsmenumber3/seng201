package entities.items.weapons;

public class Sword extends Weapon {

    // INSTANTIATION ------------------------------------------

    /**
     * This method - to instantiate a Sword object - does three things:
     * 1. It accepts all the necessary arguments in order to instantiate an Item object. This Item object in turns accept these arguments to instantiate an Entity object.
     * 2. As in the Item object that this class inherits, upon initialised, entityType is set to ITEM to denote that this is an item.
     * 3. As for this class which inherits from Item, upon initialised, itemType is set to WEAPON to denote that this is a weapon.
     * @param inputEntityName String the
     * @param inputEntityDescription
     * @param inputEntityRarity
     * @param inputEntityPurchaseValue
     * @param inputEntitySellValue
     */

    public Sword(){
        super()

    }
}