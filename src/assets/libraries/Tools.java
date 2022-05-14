package assets.libraries;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assets.enums.Difficulty;
import assets.enums.MonsterType;
// Import the Exception classes
import exceptions.InvalidInputException;


public class Tools {

    MagicNumbers magicNumbers = new MagicNumbers(); // get the constants in the MagicNumbers class
    Scanner scanner = new Scanner(System.in); // Internal
    SecureRandom random = new SecureRandom();

    // Internal
    public String readPlayerStringInput(String inputPrompt) {
        System.out.print(inputPrompt);
        return scanner.nextLine();
    }

    // Internal
    public Difficulty convertStringIntoDifficulty(String inputString) {
        Difficulty inputDifficultyLevel = null;
        try {
            if (Objects.equals(inputString, "1")) {
                inputDifficultyLevel = Difficulty.EASY;
            } else if (Objects.equals(inputString, "2")){
                inputDifficultyLevel = Difficulty.MEDIUM;
            } else if (Objects.equals(inputString, "3")) {
                inputDifficultyLevel = Difficulty.HARD;
            } else {
                throw new InvalidInputException("Enter 1, 2 or 3.");
            }
        } catch (InvalidInputException e) {
            System.out.println("Error; Handle is not a big problem as we will implement UI and this cannot happen in UI");
        }
        return inputDifficultyLevel;
    }

    public boolean TrueFalseRandom(float inputProbability) {
        return true;
    }

    /**
     * This method validates the user input where naming is required, such as the name of the Player,
     * and the names given by the Player to the Monsters. There is a number of criteria to a valid name:
     * 1. The name must be between 3-18 characters (inclusive) in length.
     * 2. The name must only contain alphanumeric characters, or points, dashes, and underscores.
     * If the name is found to be VALID, return that name as String for assignment into a variable.
     * Else, if the name is found to be INVALID, throw an InvalidInputException error.
     * InvalidInputException is a custom exception class found in seng201.classes.exceptions.
     * @param inputName String, which is the argument passed on by setPlayerName() in class Player().
     * @return inputName String, only return if the name is valid against criteria
     * @throws InvalidInputException if the name is found to be invalid
     */
    public String nameValidation(String inputName) throws InvalidInputException {
        String regex = magicNumbers.NAME_VALIDATION_REGEX;
        Pattern pattern = Pattern.compile(regex);

        if (inputName == null) {
            throw new InvalidInputException("name cannot be blank");
        } else {
            Matcher nameMatcher = pattern.matcher(inputName);
            if (!nameMatcher.matches()) {
                throw new InvalidInputException("name is invalid");
            } else {
                return inputName;
            }
        }
    }

    // GENERATE RANDOM INTEGER -----------

    public int generateRandomInteger(int inputUpperBound) {
        return random.nextInt(inputUpperBound);
    }
    
    // GENERATE RANDOM NAME --------------
    
    public String generateRandomName(MonsterType inputMonsterType) {
    	return magicNumbers.MONSTER_NAMES[generateRandomInteger(magicNumbers.MONSTER_NAMES_ARRAY_LENGTH)];
    	
    }
}