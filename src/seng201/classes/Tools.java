package seng201.classes;

import java.util.regex.*;
import seng201.classes.assets.*;

import seng201.classes.exceptions.*;

public class Tools {
    MagicNumbers magicNumbers = new MagicNumbers();

    /**
     * This method validates the userName in User(). There are many conditions to a valid username:
     * 1. The username must be of 5 characters or longer, of 13 characters or shorter.
     * 2. The username must only contain alphanumeric characters.
     * If the username is found to be VALID, return that username as String for assignment into a variable.
     * Else, if the username is found to be INVALID, throw an InvalidInputException error.
     * InvalidInputException is a custom exception class found in seng201.classes.exceptions.
     * @param inputUserName: String, which is the argument passed on by setUserName() in class User().
     * @return inputUserName: String, only return if the username is valid against criteria
     * @throws InvalidInputException, if the username is found to be invalid
     */
    public String userNameValidation(String inputUserName) throws InvalidInputException {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);

        if (inputUserName == null) {
            throw new InvalidInputException("Invalid input");
        } else if (inputUserName.length() < magicNumbers.MINIMUM_USER_NAME_CHARACTERS || 
                   inputUserName.length() > magicNumbers.MAXIMUM_USER_NAME_CHARACTERS) {
            throw new InvalidInputException("Invalid input");
        } else {
            Matcher userNameMatcher = pattern.matcher(inputUserName);
            if (userNameMatcher.matches() == false) {
                throw new InvalidInputException("Invalid input");
            } else {
                return inputUserName;
            }
        }
    }

}
