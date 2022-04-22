package assets;


import assets.enums.Difficulty;

public class MagicNumbers {

    // Constants concerning the number of days allowed
    public final int MAXIMUM_USER_DAYS = 10;
    public final int MINIMUM_USER_DAYS = 1;
    public final String NAME_VALIDATION_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

    // Default reset values for points and golds
    public final int RESET_GOLD_VALUE = 30;
    public final int RESET_POINT_VALUE = 0; // Do not change
    public final int RESET_CURRENT_DAY_VALUE = 1; // Do not change
    public final int DEFAULT_RANDOM_COMPARISON_VALUE = 0;

    // Values of entities.monsters
    public int SKELETON_VALUE;
    public int ZOMBIE_VALUE;
    public int GHAST_VALUE;
    public int WITHER_VALUE;
    public int MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE = 100;
    public int MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE = 0;
    public final int MINIMUM_MONSTER_SELL_PRICE = 0;
    public int DEFAULT_MONSTER_HEALTH_LEVEL = 100;

    public MagicNumbers() {
        // This is legal, but do nothing.
    }

    public MagicNumbers(Difficulty inputDifficulty) {
        if (inputDifficulty.equals(Difficulty.EASY)) {
            this.SKELETON_VALUE = 40;
            this.ZOMBIE_VALUE = 30;
        }
    }


}