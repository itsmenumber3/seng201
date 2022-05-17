package assets.libraries;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assets.enums.MonsterType;
// Import the Exception classes
import entities.monsters.Monster;
import exceptions.InvalidInputException;
import main.Player;


public class Tools {

    MagicNumbers magicNumbers = new MagicNumbers(); // get the constants in the MagicNumbers class
    Scanner scanner = new Scanner(System.in); // Internal
    SecureRandom random = new SecureRandom();

    // Internal
    public String readPlayerStringInput(String inputPrompt) {
        System.out.print(inputPrompt);
        return scanner.nextLine();
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

    
    /***
     * public Monster generateRandomMonster(Player inputPlayer) {
     *         if (inputPlayer.getPlayerCurrentDay() / inputPlayer.getPlayerDays()) <=0.3 {
     *             // randomise a difficulty level between 1 and 2
     *         } else if // the thng is larger than 0.3 but smaller than 0.6 {
     *             // 1 and 3
     *         } elise if // if it is betwwen 0.6 and 0.9
     *             /// randomse a rarity level between 2 and 3
     *     }
     * @param inputPlayer
     * @return
     */
    
    public int generaterRandomMonsterRarity(Player inputPlayer) {
    	double ratio = inputPlayer.getPlayerCurrentDay() / inputPlayer.getPlayerDays();
    	int randInt = 0;
    	if (ratio <= magicNumbers.LOWER_BOUND_RARITY) {
    		randInt = random.nextInt(2);
    	}
    	else if (ratio <= magicNumbers.MIDDLE_BOUND_RARITY) {
    		randInt = random.nextInt(2,4);
    	}
    	else if (ratio <= magicNumbers.UPPER_BOUND_RARITY) {
    		randInt = random.nextInt(3,5);
    	}
    	return randInt;
    }
    
    
    public monster generateRandomMonster(Player inputPlayer) {
    	int randInt = random.nextInt(MONSTER_TYPES_LENGTH);
    	
    	Monster monster;
    	
    	switch(randInt) {
    	case (0):
    		monster = new Skeleton();
    		break;
    	case (1):
    		monster = new Spirit(0);
    		break;
    	case (2):
    		monster = new Troll();
    		break;
    	case (3):
    		monster = new Zombie();
    		break;
    	case (4):
    		monster = new Dragon();
    		break;
    	}
    	
    	return monster;
    }
    
    public int howManyMonstersBasedOnDifficulty(int inputDifficulty) {
    	if (inputDifficulty == 1) {
    		return 5;
    	} else if (inputDifficulty == 2) {
    		return 4;
    	} else {
    		return 3;
    	}
    }

}