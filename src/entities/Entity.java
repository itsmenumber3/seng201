package entities;

import assets.enums.EntityType;
import assets.libraries.MagicNumbers;
import assets.libraries.Tools;
import assets.enums.Rarity;
import exceptions.InvalidInputException;
import exceptions.MaximumStringLengthExceededException;
import exceptions.UnexpectedNegativeNumberException;

/**
 * An Entity is something that can be owned, used and traded by the player.
 * This means items (food, weapons, potions, shield) AND monsters (Troll, Skeleton, Wither, Zombie)
 * are all entities. The classes for items and monsters are extended from this class, Entity.
 * @see entities.monsters.Monster
 * @see entities.items.Item
 */
public abstract class Entity {

    // LIBRARIES ------------------------------------------

    /**
     * tools: Tools contains some the reusable functionalities needed throughout the program such as
     * command line input, name validation, and random number generator.
     */
    public Tools tools = new Tools();

    /**
     * magicNumber: MagicNumbers s is an object storing all constants needed in this program.
     */
    public MagicNumbers magicNumbers = new MagicNumbers();

    // LIBRARIES ------------------------------------------



    // INSTANTIATION --------------------------------------

    /**
     * This method creates an instance of the class Entity.
     * @param inputEntityName String that is the name entity.
     * @param inputEntityDescription String that is the description of the entity.
     * @param inputEntityRarity Rarity that describes how rare the entity is COMMON, UNCOMMON, RARE
     * @param inputEntityPurchaseValue integer
     * @param inputEntitySellValue integer
     */
    public Entity(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue) {
        this.setEntityName(inputEntityName);
        this.setEntityDescription(inputEntityDescription);
        this.setEntityRarity(inputEntityRarity);
        this.setEntityPurchaseValue(inputEntityPurchaseValue);
        this.setEntitySellValue(inputEntitySellValue);
    }

    // INSTANTIATION --------------------------------------



    // ENTITY TYPE ----------------------------------------

    /**
     * The entity type describes what kind of entity this is (either an item or a monster).
     * @see EntityType
     */
    EntityType entityType;

    /**
     * This method allows for defining what kind of entity this is
     * @param inputEntityType EntityType, which is an enum type
     * @see EntityType
     */
    public void setEntityType(EntityType inputEntityType) {
        this.entityType = inputEntityType;
    }

    /**
     * This method returns what kind of entity this is
     * @return entityType - EntityType, which is an enum type
     * @see EntityType
     */
    public EntityType getEntityType() {
        return this.entityType;
    }

    // ENTITY TYPE ----------------------------------------



    // ENTITY NAME ----------------------------------------

    /**
     * entityName: String stores the custom name of the entity.
     */
    private String entityName;

    /**
     * This method assigns the input string to the name of the entity.
     * The input string must adhere to the Name Rules because it will be validated by nameValidation() in Tools.
     * If violated, throw the error InvalidInputException
     * @param inputEntityName String, the input string
     * @see Tools
     * @see InvalidInputException
     */
    public void setEntityName(String inputEntityName) {
        try {
            this.entityName = tools.nameValidation(inputEntityName);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the name of the entity.
     * @return entityName String, the name of the entity.
     */
    public String getEntityName() {
        return this.entityName;
    }

    // ENTITY NAME ----------------------------------------



    // ENTITY DESCRIPTION ---------------------------------

    /**
     * This string provides a brief description of the entity.
     */
    private String entityDescription;

    /**
     * This method assigns an input string as a brief description string of entity.
     * If this input string is too long (over 200 characters) throw an MaximumStringLengthExceededException
     * @param inputEntityDescription String, provide a 200-word or less description here.
     * @see InvalidInputException
     */
    public void setEntityDescription(String inputEntityDescription) {
        try {
            if (inputEntityDescription.length() <= magicNumbers.MAXIMUM_ENTITY_DESCRIPTION_CHARACTER_LENGTH) {
                this.entityDescription = inputEntityDescription;
            } else {
                throw new MaximumStringLengthExceededException("Description too long");
            }
        } catch (MaximumStringLengthExceededException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method returns the string description of entity
     * @return entityDescription String
     */
    public String getEntityDescription() {
        return this.entityDescription;
    }

    // ENTITY DESCRIPTION ---------------------------------



    // RARITY ---------------------------------------------

    /**
     * This variable stores how rare the entity is. It is of enum type Rarity.
     * There are three Rarity levels: COMMON, UNCOMMON, RARE.
     */
    private Rarity entityRarity;

    /**
     * This method accepts an input of type Rarity and assign it to entityRarity.
     * @param inputEntityRarity Rarity
     * @see Rarity
     */
    public void setEntityRarity(Rarity inputEntityRarity) {
        this.entityRarity = inputEntityRarity;
    }

    /**
     * This method returns the rarity of the entity.
     * @return entityRarity Rarity
     */
    public Rarity getEntityRarity() {
        return this.entityRarity;
    }

    // RARITY ---------------------------------------------



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

}
