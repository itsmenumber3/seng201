package assets;

import java.util.*;
import java.util.regex.*;

import assets.enums.Difficulty;
import exceptions.*; // Import the Exception classes


public class Tools {
    MagicNumbers magicNumbers = new MagicNumbers();
    Scanner scanner = new Scanner(System.in);

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

    /**
     * This method validates the playerName in Player(). There are many conditions to a valid playerName:
     * 1. The playerName must be of 5 characters or longer, of 13 characters or shorter.
     * 2. The playerName must only contain alphanumeric characters.
     * If the playerName is found to be VALID, return that playerName as String for assignment into a variable.
     * Else, if the playerName is found to be INVALID, throw an InvalidInputException error.
     * InvalidInputException is a custom exception class found in seng201.classes.exceptions.
     * @param inputPlayerName: String, which is the argument passed on by setPlayerName() in class Player().
     * @return inputPlayerName: String, only return if the playerName is valid against criteria
     * @throws InvalidInputException, if the playerName is found to be invalid
     */
    public String playerNameValidation(String inputPlayerName) throws InvalidInputException {
        String regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(regex);

        if (inputPlayerName == null) {
            throw new InvalidInputException("playerName cannot be blank");
        } else {
            Matcher playerNameMatcher = pattern.matcher(inputPlayerName);
            if (!playerNameMatcher.matches()) {
                throw new InvalidInputException("playerName is invalid");
            } else {
                return inputPlayerName;
            }
        }
    }

}