package assets.libraries;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assets.enums.MonsterType;
import entities.monsters.Dragon;
// Import the Exception classes
import entities.monsters.Monster;
import entities.monsters.Skeleton;
import entities.monsters.Spirit;
import entities.monsters.Troll;
import entities.monsters.Zombie;
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
    

    public int howManyMonstersBasedOnDifficulty(int inputDifficulty) {
    	if (inputDifficulty == 1) {
    		return 5;
    	} else if (inputDifficulty == 2) {
    		return 4;
    	} else {
    		return 3;
    	}
    }
    
    public Monster generateRandomMonster(Player inputPlayer) {
    	Monster monster;
    	
    	// First step is to randomize a type of monster;
    	int randInt = random.nextInt(1, magicNumbers.MONSTER_TYPES.length);
    	
    	switch(randInt) {
	    	case (1):
	    		monster = new Skeleton();
	    		break;
	    	case (2):
	    		monster = new Spirit();
	    		break;
	    	case (3):
	    		monster = new Troll();
	    		break;
	    	case (4):
	    		monster = new Zombie();
	    		break;
	    	default:
	    		monster = new Dragon();
	    		break;
    	}
    	
    	// Second step is to randomize its rarity (based on days)
    	double playerProgress = inputPlayer.getPlayerCurrentDay() / inputPlayer.getPlayerDays();
    	
    	if (playerProgress <= 0.33) {
    		monster.setEntityRarity(magicNumbers.RARITY_POSSIBILITIES_START_OF_GAME[random.nextInt(magicNumbers.RARITY_POSSIBILITIES_START_OF_GAME.length)]);
    	} else if (playerProgress <= 0.66) {
    		monster.setEntityRarity(magicNumbers.RARITY_POSSIBILITIES_MID_OF_GAME[random.nextInt(magicNumbers.RARITY_POSSIBILITIES_MID_OF_GAME.length)]);
    	} else {
    		monster.setEntityRarity(magicNumbers.RARITY_POSSIBILITIES_END_OF_GAME[random.nextInt(magicNumbers.RARITY_POSSIBILITIES_END_OF_GAME.length)]);
    	}
    	
    	
    	// Third step is to randomize its attack damage.
    	if (inputPlayer.getPlayerDifficulty() == 1) {
    		if (monster.getMonsterType() == MonsterType.SKELETON) {
    			monster.setMonsterResistanceAbility(random.nextInt(8, 14));
    		} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    			monster.setMonsterResistanceAbility(random.nextInt(11, 17));
    		} else if(monster.getMonsterType() == MonsterType.TROLL) {
    			monster.setMonsterResistanceAbility(random.nextInt(14, 20));
    		} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    			monster.setMonsterResistanceAbility(random.nextInt(17, 23));
    		};
    		
    	} else if (inputPlayer.getPlayerDifficulty() == 2) {
    		if (monster.getMonsterType() == MonsterType.SKELETON) {
    			monster.setMonsterResistanceAbility(random.nextInt(8, 14));
    		} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    			monster.setMonsterResistanceAbility(random.nextInt(11, 17));
    		} else if(monster.getMonsterType() == MonsterType.TROLL) {
    			monster.setMonsterResistanceAbility(random.nextInt(14, 20));
    		} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    			monster.setMonsterResistanceAbility(random.nextInt(17, 23));
    		};
    	} else {
    		if (monster.getMonsterType() == MonsterType.SKELETON) {
    			monster.setMonsterResistanceAbility(random.nextInt(8, 14));
    		} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    			monster.setMonsterResistanceAbility(random.nextInt(11, 17));
    		} else if(monster.getMonsterType() == MonsterType.TROLL) {
    			monster.setMonsterResistanceAbility(random.nextInt(14, 20));
    		} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    			monster.setMonsterResistanceAbility(random.nextInt(17, 23));
    		};
    	} // to complete implementation 
    	
    	monster.setMonsterAttackDamage(10); // to be implemented
    	
    	monster.resetMonsterHealthLevel();

    	
    	return monster;
    }
    
    public ArrayList<Monster> generateManyRandomMonsters(Player inputPlayer, int inputSize) {
    	ArrayList<Monster> monsters = new ArrayList<>();
    	for (int index = 0; index < inputSize; index++) {
    		monsters.add(this.generateRandomMonster(inputPlayer));
    	}
    	return monsters;
    }
    
    public String makeStringDescriptionFromMonsterInformation(Monster inputMonster) {
    	return String.format("This monster is a %s. It has an attack damage of %d and its resistance ability is %d. It is of rarity level %d. Currently, its health is %d out of 100.", inputMonster.getMonsterType().toString(), inputMonster.getMonsterAttackDamage(), inputMonster.getMonsterResistanceAbility(), inputMonster.getMonsterHealthLevel());
    }
    
    public String generateRandomMonsterName() {
    	return magicNumbers.RANDOM_MONSTER_NAMES[random.nextInt(magicNumbers.RANDOM_MONSTER_NAMES.length)];
    }

}