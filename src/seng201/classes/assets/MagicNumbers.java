package seng201.classes.assets;

import java.nio.charset.CharacterCodingException;

import seng201.classes.Difficulty;

public class MagicNumbers {

    // Constants concerning the number of days allowed
    public int MAXIMUM_USER_DAYS = 10;
    public int MINIMUM_USER_DAYS = 1;
    public String INVALID_USER_DAYS_ERROR_MESSAGE = "Invalid game days - please choose between 1 and 10 inclusive.";

    public int MAXIMUM_USER_NAME_CHARACTERS = 13;
    public int MINIMUM_USER_NAME_CHARACTERS = 1;

    public MagicNumbers() {
        // This is legal, but do nothing.
    }

    public MagicNumbers(Difficulty difficultyLevel) {
        // Do nothign lol
    }


}