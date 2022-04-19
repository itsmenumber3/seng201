package seng201.classes;

import java.util.regex.*;
import seng201.classes.assets.*;

public class Tools {
    MagicNumbers magicNumbers = new MagicNumbers();

    public boolean IsUserNameValid(String inputUserName) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);

        if (inputUserName == null) {
            return false;
        } else if (inputUserName.length() < magicNumbers.MINIMUM_USER_NAME_CHARACTERS || 
                   inputUserName.length() > magicNumbers.MAXIMUM_USER_NAME_CHARACTERS) {
            return false;
        } else {
            Matcher userNameMatcher = pattern.matcher(inputUserName);
            return userNameMatcher.matches();
        }
    }


}
