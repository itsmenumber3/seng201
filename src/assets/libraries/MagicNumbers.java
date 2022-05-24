package assets.libraries;


import assets.enums.MonsterType;

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
    public MagicNumbers(int inputDifficulty) {
        if (inputDifficulty == 1) {
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
    public final int MAXIMUM_USER_DAYS = 15;

    /**
     * This is the minimum number of days that the player can choose to play.
     * Less than this and it's illegal, so throw an InvalidInputException in that case.
     * @see exceptions.InvalidInputException
     */
    public final int MINIMUM_USER_DAYS = 5;

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
    public final int RESET_GOLD_VALUE = 50;

    /**
     * This is the starting number of points the player has, or when the game restarts.
     * @see main.Player
     */
    public final int RESET_POINT_VALUE = 0; // Do not change

    /**
     * This is the day that should be set when the game starts or restarts.
     * @see main.Player
     */
    public final int RESET_CURRENT_DAY_VALUE = 0; // Do not change

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
    public final int MINIMUM_ENTITY_SELL_PRICE = 0;
    public final int MINIMUM_MONSTER_PURCHASE_PRICE = 0;

    public final int MINIMUM_RARITY = 1;
    public final int MAXIMUM_RARITY = 5;
    public final int MAXIMUM_MONSTERS_NUMBER_IN_TEAM = 4;
   
    public final double LOWER_BOUND_RARITY = 0.3;
    public final double MIDDLE_BOUND_RARITY = 0.6;
    public final double UPPER_BOUND_RARITY = 1.0;

    public final int[] RARITY_POSSIBILITIES_START_OF_GAME = {1, 2};
    public final int[] RARITY_POSSIBILITIES_MID_OF_GAME = {1, 2, 3};
    public final int[] RARITY_POSSIBILITIES_END_OF_GAME = {1, 2, 2, 3, 3}; 
    
    public final String[] RANDOM_MONSTER_NAMES = {"Smogfang", "Goolops", "Doomboo", "Muckga", "Emberbug", "Acidgirl", "Ghosteyes", "Vaporman"};

    public final MonsterType[] MONSTER_TYPES = {MonsterType.SKELETON, MonsterType.SPIRIT, MonsterType.TROLL, MonsterType.ZOMBIE, MonsterType.DRAGON};

    public final int MAXIMUM_ENTITY_DESCRIPTION_CHARACTER_LENGTH = 200;

    public final int[] RESISTANCE_AND_ATTACK_RANGE = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    
    public final int BATTLE_ATTACK_EASY = 30;
    public final int BATTLE_RESISTANCE_EASY = 5;
    
    public final int BATTLE_ATTACK_MED = 40;
    public final int BATTLE_RESISTANCE_MED = 10;
    
    public final int BATTLE_ATTACK_HARD = 60;
    public final int BATTLE_RESISTANCE_HARD = 15;
    
    public final int PASTA_SELL_VALUE = 16;
    public final int APPLE_SELL_VALUE = 7;
    public final int FOOD_VAR = 8;
    
    public final int COFFEE_SELL_VALUE = 5;
    public final int ENERGY_DRINK_SELL_VALUE = 12;
    public final int DRINK_VAR = 6;
    
    




}
