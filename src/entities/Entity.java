package entities;

import assets.libraries.MagicNumbers;
import assets.libraries.Tools;
import assets.enums.Rarity;
import exceptions.InvalidInputException;
import exceptions.UnexpectedNegativeNumberException;

/**
 * An Entity is something that can be owned, used and traded by the player.
 * This means items (food, weapons, potions, shield) AND monsters (Ghast, Skeleton, Wither, Zombie)
 * are all entities. The classes for items and monsters are extended from this class, Entity.
 * @see entities.monsters.Monster
 * @see entities.items.Item
 */
public class Entity {

    // LIBRARIES ------------------------------------------

    /**
     * tools: Tools contains some the reusable functionalities needed throughout the program such as
     * command line input, name validation, and random number generator.
     */
    Tools tools = new Tools();

    /**
     * magicNumber: MagicNumbers s is an object storing all constants needed in this program.
     */
    MagicNumbers magicNumbers = new MagicNumbers();

    // LIBRARIES ------------------------------------------



    // SELL VALUE -----------------------------------------

    /**
     * entitySellValue: integer stores the gold value that the player can sell their owned entity to the shop for.
     */
    private int entitySellValue;

    /**
     * This method assigns a gold value to integer variable entitySellValue.
     * entitySellValue: integer stores the gold value that the player can sell their owned entity to the shop for.
     * @param inputEntitySellValue integer, which is what you want the sell value to be.This input value must
     *                             be equal or greater than constant MINIMUM_MONSTER_SELL_PRICE: integer
     *                             set in class MagicNumbers otherwise it will throw an error - UnexpectedNegativeNumberException
     */
    public void setEntitySellValue(int inputEntitySellValue) {
        try {
            if (inputEntitySellValue >= magicNumbers.MINIMUM_MONSTER_SELL_PRICE) {
                this.entitySellValue = inputEntitySellValue;
            } else {
                throw new UnexpectedNegativeNumberException("Unexpected negative number");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the entitySellValue.
     * entitySellValue: integer stores the gold value that the player can sell their owned entity to the shop for.
     * @return entitySellValue integer
     */
    public int getEntitySellValue() {
        return this.entitySellValue;
    }

    // SELL VALUE -----------------------------------------



    // PURCHASE VALUE -------------------------------------

    /**
     * entityPurchaseValue: integer is the gold value of the entity that the shop sells to the player.
     */
    private int entityPurchaseValue;

    /**
     * This method accepts a gold value integer input and sets the entityPurchaseValue to that input value.
     * entityPurchaseValue: integer is the gold value of the entity that the shop sells to the player.
     * @param inputEntityPurchaseValue integer, which is what you want the purchase price to be. This input value must
     *                                 be equal or greater than constant MINIMUM_MONSTER_PURCHASE_PRICE: integer
     *                                 set in class MagicNumbers otherwise it will throw an error - UnexpectedNegativeNumberException
     * @see MagicNumbers
     */
    public void setEntityPurchaseValue(int inputEntityPurchaseValue) {
        try {
            if (inputEntityPurchaseValue >= magicNumbers.MINIMUM_MONSTER_SELL_PRICE) {
                this.entityPurchaseValue = inputEntityPurchaseValue;
            } else {
                throw new UnexpectedNegativeNumberException("Unexpected negative number");
            }
        } catch (UnexpectedNegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the entityPurchaseValue.
     * entityPurchaseValue: integer is the gold value of the entity that the shop sells to the player.
     * @return entityPurchaseValue integer
     */
    public int getEntityPurchaseValue() {
        return this.entityPurchaseValue;
    }

    // PURCHASE VALUE -------------------------------------



    // ENTITY NAME ----------------------------------------

    /**
     * entityName: String is a string
     */
    private String entityName;

    public void setEntityName(String inputEntityName) {
        try {
            this.entityName = tools.nameValidation(inputEntityName);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    public String getEntityName() {
        return this.entityName;
    }

    private String entityDescription;

    public void setEntityDescription(String inputEntityDescription) {
        this.entityDescription = inputEntityDescription;
    }

    public String getEntityDescription() {
        return this.entityDescription;
    }

    private Rarity entityRarity;

    public void setEntityRarity(Rarity inputEntityRarity) {
        this.entityRarity = inputEntityRarity;
    }

    public Rarity getEntityRarity() {
        return this.entityRarity;
    }
}
