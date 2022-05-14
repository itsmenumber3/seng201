package assets.libraries;


import assets.enums.Difficulty;

/**
 * This class is a central place to store all constants as needed throughout this program.
 * This is based on the principle of best programming practices, whereby the program and numeric values
 * should be separated for convenient development and maintenance purposes.
 */
public class MagicNumbers {

    // INSTANTIATION --------------------------------------------------------------

    /**
     * Instantiation of MagicNumbers without a difficulty level is legal.
     * However, difficulty-specific variables will not be assigned a value.
     */
    public MagicNumbers() {

    }

    /**
     * Instantiation of MagicNumbers with a difficulty level will assign values to difficulty-specific variables.
     * @param inputDifficulty Difficulty, the level of difficulty in question.
     */
    public MagicNumbers(Difficulty inputDifficulty) {
        if (inputDifficulty.equals(Difficulty.EASY)) {
            this.SKELETON_VALUE = 40;
            this.ZOMBIE_VALUE = 30;
        }
    }

    // INSTANTIATION --------------------------------------------------------------




    // CONSTANTS FOR PLAYER INPUT VALIDATION ---------------------------------------

    /**
     * This is the maximum number of days that the player can choose to play.
     * More than this and it's illegal, so throw an InvalidInputException in that case.
     * @see exceptions.InvalidInputException
     */
    public final int MAXIMUM_USER_DAYS = 10;

    /**
     * This is the minimum number of days that the player can choose to play.
     * Less than this and it's illegal, so throw an InvalidInputException in that case.
     * @see exceptions.InvalidInputException
     */
    public final int MINIMUM_USER_DAYS = 1;

    /**
     * This is the regex string that can be used to validate the player input when they name something, such as themselves or an entity.
     * @see Tools
     */
    public final String NAME_VALIDATION_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

    // CONSTANTS FOR PLAYER INPUT VALIDATION ---------------------------------------



    // CONSTANTS SETTING DEFAULT VALUES --------------------------------------------

    /**
     * This is the starting gold value balance for the player in the game, or when the game restarts.
     * @see main.Player
     */
    public final int RESET_GOLD_VALUE = 30;

    /**
     * This is the starting number of points the player has, or when the game restarts.
     * @see main.Player
     */
    public final int RESET_POINT_VALUE = 0; // Do not change

    /**
     * This is the day that should be set when the game starts or restarts.
     * @see main.Player
     */
    public final int RESET_CURRENT_DAY_VALUE = 1; // Do not change

    /**
     * This is
     */
    public final int RESET_ITEM_QUANTITY = 0;

    /**
     * This is the default health value of monster when initialised or reset.
     */
    public final int DEFAULT_MONSTER_HEALTH_LEVEL = 100;
    public final int DEFAULT_RANDOM_COMPARISON_VALUE = 0;

    // Values of entities.monsters
    public int SKELETON_VALUE;
    public int ZOMBIE_VALUE;
    public int GHAST_VALUE;
    public int WITHER_VALUE;
    public int MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE = 100;
    public int MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE = 0;
    public final int MINIMUM_MONSTER_SELL_PRICE = 0;
    public final int MINIMUM_MONSTER_PURCHASE_PRICE = 0;

    public final int MAXIMUM_MONSTERS_NUMBER_IN_TEAM = 4;


    public final int MAXIMUM_ENTITY_DESCRIPTION_CHARACTER_LENGTH = 200;

    public String[] MONSTER_NAMES = {"Fred", "Francis", "Jono", "Toby"};
    public int MONSTER_NAMES_ARRAY_LENGTH = MONSTER_NAMES.length;



}