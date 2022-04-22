package entities;

import assets.MagicNumbers;
import assets.Tools;
import assets.enums.Rarity;
import exceptions.InvalidInputException;
import exceptions.UnexpectedNegativeNumberException;

public class Entity {
    // LIBRARIES ------------------------------------------

    /**
     * Contains some the reusable functionalities such as command line input, name validation, and random number generator.
     */
    Tools tools = new Tools();

    /**
     * Contains the constants.
     */
    MagicNumbers magicNumbers = new MagicNumbers();
    // LIBRARIES ------------------------------------------



    // SELL VALUE -----------------------------------------

    /**
     * entitySellValue: integer stores the gold value that the player can sell their owned monster for.
     */
    private int entitySellValue;

    /**
     * This method assigns a gold value to entitySellValue regarding how much gold the monster should be sold to the store.
     * @param inputEntitySellValue integer
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
     * @return entitySellValue integer.
     */
    public int getEntitySellValue() {
        return this.entitySellValue;
    }

    // SELL VALUE -----------------------------------------



    // PURCHASE VALUE -------------------------------------

    /**
     * entityPurchaseValue
     */
    private int entityPurchaseValue;

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

    public int getEntityPurchaseValue() {
        return this.entityPurchaseValue;
    }

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
