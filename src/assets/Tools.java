package assets;


import java.util.regex.*;

import main.*; // Import Inventory and Shop
import assets.*; // Import MagicNumbers and Tools
import exceptions.*; // Import the Exception classes
import items.*; // Import items that player can buy and hold
import monsters.*; // Import monsters that player can buy and hold

public class Tools {
    MagicNumbers magicNumbers = new MagicNumbers();

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
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);

        if (inputPlayerName == null) {
            throw new InvalidInputException(String.format("playerName cannot be blank.\n" +
                                                            "The playerName length must be between %d-%d characters inclusive (violated).\n" +
                                                            "The playerName must only contain alphanumeric A-Z, 0-9 characters.%n",
                                                            magicNumbers.MINIMUM_USER_NAME_CHARACTERS, magicNumbers.MAXIMUM_USER_NAME_CHARACTERS));
        } else if (inputPlayerName.length() < magicNumbers.MINIMUM_USER_NAME_CHARACTERS || inputPlayerName.length() > magicNumbers.MAXIMUM_USER_NAME_CHARACTERS) {
            throw new InvalidInputException(String.format("playerName is invalid.\n" +
                                                            "The playerName length must be between %d-%d characters inclusive (violated).\n" +
                                                            "The playerName must only contain alphanumeric A-Z, 0-9 characters.%n",
                                                            magicNumbers.MINIMUM_USER_NAME_CHARACTERS, magicNumbers.MAXIMUM_USER_NAME_CHARACTERS));
        } else {
            Matcher playerNameMatcher = pattern.matcher(inputPlayerName);
            if (!playerNameMatcher.matches()) {
                throw new InvalidInputException(String.format("playerName is invalid.\n" +
                                                                "The playerName length must be between %d-%d characters inclusive.\n" +
                                                                "The playerName must only contain alphanumeric A-Z, 0-9 characters (violated).%n",
                                                                magicNumbers.MINIMUM_USER_NAME_CHARACTERS, magicNumbers.MAXIMUM_USER_NAME_CHARACTERS));
            } else {
                return inputPlayerName;
            }
        }
    }

}