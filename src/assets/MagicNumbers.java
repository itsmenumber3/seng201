package assets;


import enums.Difficulty;

public class MagicNumbers {

    // Constants concerning the number of days allowed
    public int MAXIMUM_USER_DAYS = 10;
    public int MINIMUM_USER_DAYS = 1;
    public String INVALID_USER_DAYS_ERROR_MESSAGE = "Invalid game days - please choose between 1 and 10 inclusive.";

    public int MAXIMUM_USER_NAME_CHARACTERS = 13;
    public int MINIMUM_USER_NAME_CHARACTERS = 1;

    public int SKELETON_VALUE;
    public int ZOMBIE_VALUE;
    public int GHAST_VALUE;
    public int WITHER_VALUE;

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