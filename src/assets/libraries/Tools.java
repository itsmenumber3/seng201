package assets.libraries;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assets.enums.MonsterType;
import entities.monsters.battle_monsters.*;
import entities.monsters.tradeable_monsters.Dragon;
// Import the Exception classes
import entities.monsters.Monster;
import entities.monsters.tradeable_monsters.Skeleton;
import entities.monsters.tradeable_monsters.Spirit;
import entities.monsters.tradeable_monsters.Troll;
import entities.monsters.tradeable_monsters.Zombie;
import exceptions.InvalidInputException;
import main.Player;


public class Tools {

    MagicNumbers magicNumbers = new MagicNumbers(); // get the constants in the MagicNumbers class
    SecureRandom random = new SecureRandom();


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
    		return 4;
    	} else if (inputDifficulty == 2) {
    		return 3;
    	} else {
    		return 2;
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
    	
    	
    	// Third step is to randomize its attack damage and its resistance ability
    	if (inputPlayer.getPlayerDifficulty() == 1) {
			if (monster.getEntityRarity() == 1){
    			if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[21]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[20]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
				}
			}
			else if (monster.getEntityRarity() == 2){
				if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
				}	
			}
			else {
				if (monster.getMonsterType() == MonsterType.SKELETON) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[20]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[21]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
				}	
			}
		}
    	else if (inputPlayer.getPlayerDifficulty() == 2) {
			if (monster.getEntityRarity() == 1){
    			if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[1],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[20]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
				}
			}
			else if (monster.getEntityRarity() == 2){
				if (monster.getMonsterType() == MonsterType.SKELETON) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
					monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
				}	
			}
			else {
				if (monster.getMonsterType() == MonsterType.SKELETON) {
					monster.setMonsterResistanceAbility(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
					monster.setMonsterAttackDamage(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
				} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
					monster.setMonsterResistanceAbility(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
					monster.setMonsterAttackDamage(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
				} else if (monster.getMonsterType() == MonsterType.TROLL) {
					monster.setMonsterResistanceAbility(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
					monster.setMonsterAttackDamage(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
				} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
					monster.setMonsterResistanceAbility(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
					monster.setMonsterAttackDamage(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON) {
					monster.setMonsterResistanceAbility(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[20]));
					monster.setMonsterAttackDamage(random.nextInt(
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[1],
							magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6]));
				}
			}
    	} else {
			if (monster.getEntityRarity() == 1){
    			if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[0],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[1],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
				}
			}
			else if (monster.getEntityRarity() == 2){
				if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10]));
				}	
			}
			else{
				if (monster.getMonsterType() == MonsterType.SKELETON) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[10],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[15]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[4],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[9]));
    			} else if (monster.getMonsterType() == MonsterType.SPIRIT) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[11],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[16]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[3],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[8]));
    			} else if(monster.getMonsterType() == MonsterType.TROLL) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[12],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[17]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[2],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[7]));
    			} else if (monster.getMonsterType() == MonsterType.ZOMBIE) {
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[13],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[18]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[1],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[6]));
				} else if (monster.getMonsterType() == MonsterType.DRAGON){
    				monster.setMonsterResistanceAbility(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[14],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[19]));
					monster.setMonsterAttackDamage(random.nextInt(
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[0],
						magicNumbers.RESISTANCE_AND_ATTACK_RANGE[5]));
				}	
			}
    	} 
		
		 // to complete implementation 
    	
    	
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

	public Monster generateRandomBattleMonster(MonsterType inputMonsterType, Player inputPlayer) {
		Monster monster;
		try {
			switch (inputMonsterType) {
				case MUD_MONSTER:
					monster = new MudMonster();
					monster.setEntityName("Mud Boss Monster");
					break;
				case SAND_MONSTER:
					monster = new SandMonster();
					monster.setEntityName("Sand Boss Monster");
					break;
				case WATER_MONSTER:
					monster = new WaterMonster();
					monster.setEntityName("Water Boss Monster");
					break;
				case SNOW_MONSTER:
					monster = new SnowMonster();
					monster.setEntityName("Snow Boss Monster");
					break;
				case GRASS_MONSTER:
					monster = new GrassMonster();
					monster.setEntityName("Grass Boss Monster");
					break;
				default:
					throw new InvalidInputException("Unallowed monster");
			}
			
			if (inputPlayer.getPlayerDifficulty() == 1) {
				monster.setMonsterAttackDamage(magicNumbers.BATTLE_ATTACK_EASY);
				monster.setMonsterResistanceAbility(magicNumbers.BATTLE_RESISTANCE_EASY);
			}
			else if (inputPlayer.getPlayerDifficulty() == 2) {
				monster.setMonsterAttackDamage(magicNumbers.BATTLE_ATTACK_MED);
				monster.setMonsterResistanceAbility(magicNumbers.BATTLE_RESISTANCE_MED);
				
			}
			else {
				monster.setMonsterAttackDamage(magicNumbers.BATTLE_ATTACK_HARD);
				monster.setMonsterResistanceAbility(magicNumbers.BATTLE_RESISTANCE_HARD);
				
			}
			monster.resetMonsterHealthLevel();
			
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		return monster;
	}

}
