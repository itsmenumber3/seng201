package assets.libraries;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assets.enums.*;
import battles.Battle;
import battles.challenge.Challenge;
import battles.challenge.FlipACoin;
import battles.challenge.PaperScissorsRock;
import battles.challenge.Quiz;
import entities.items.consumables.Food;
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
	QuizData quizData = new QuizData();


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
    	return String.format("This monster is a %s. It has an attack damage of %.2f and its resistance ability is %.2f. It is of rarity level %d. Currently, its health is %.2f out of 100.",
				inputMonster.getMonsterType().toString(),
				inputMonster.getMonsterAttackDamage(),
				inputMonster.getMonsterResistanceAbility(),
				inputMonster.getEntityRarity(),
				inputMonster.getMonsterHealthLevel());
    }
    
    public String generateRandomMonsterName() {
    	return magicNumbers.RANDOM_MONSTER_NAMES[random.nextInt(magicNumbers.RANDOM_MONSTER_NAMES.length)];
    }

	public Monster generateRandomBattleMonster(MonsterType inputMonsterType, Player inputPlayer) {
		Monster monster = new Monster();
		
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
		
		monster.setEntitySellbackValue(random.nextInt(70, 100));
		
		return monster;
	}
	
	public String makeBattleDescription(Battle inputBattle) {
		String[] creativeMonstersDescriptionStrings = {"It is a dangerous monster that has taken the lives of many people.", 
												"Many village residents have disappeared, and they suspect nothing else but this monster.", 
												"Residents are fearful, and they need your help to conquer this monster."};
		return String.format("%s is home to the monster %s. %s Kill it, and you get rewarded with %d gold coins. Lose it and game is over. The stakes are high. Are you ready?", 
				inputBattle.getBattleName(), inputBattle.getBattleMonster().getEntityName(), creativeMonstersDescriptionStrings[random.nextInt(0, creativeMonstersDescriptionStrings.length)], 
				inputBattle.getBattleMonster().getEntitySellValue());
	}

	public Challenge makeRandomChallenge() {
		Challenge challenge;
		switch (random.nextInt(0, 2)) {
			case 0:
				challenge = new PaperScissorsRock();
				break;
			case 1:
				challenge = new FlipACoin();
				break;
			default:
				challenge = makeRandomQuiz();
		}
		return challenge;
	}

	public Quiz makeRandomQuiz() {
		Quiz quiz = new Quiz();
		String[] questionData = this.quizData.getQuestion(random.nextInt(1, 10));
		quiz.setQuizQuestion(questionData[0]);
		quiz.setQuizChoices(Arrays.copyOfRange(questionData, 1, 5));
		quiz.setQuizCorrectChoice(questionData[5]);
		return quiz;
	}

	public FightOutcomeType runFight(Player inputPlayer) {
		if (inputPlayer.getPlayerSelectedBattle().getCurrentChallenge().getChallengeOutcome() == ChallengeOutcomeType.WIN) {
			// Player monster attacks battle monster
			inputPlayer.getPlayerSelectedBattle().getBattleMonster().monsterGetsAttacked(
					inputPlayer.getPlayerInventory().getMonsters().get(0).getMonsterAttackDamage());
		} else if (inputPlayer.getPlayerSelectedBattle().getCurrentChallenge().getChallengeOutcome() == ChallengeOutcomeType.LOSE) {
			// Player monster is attacked by battle monster
			inputPlayer.getPlayerInventory().getMonsters().get(0).monsterGetsAttacked(
					inputPlayer.getPlayerSelectedBattle().getBattleMonster().getMonsterAttackDamage());
		} // Skip entirely if draw RPS

		if (inputPlayer.getPlayerInventory().getMonsters().get(0).getMonsterHealthLevel() > 0) {
			if (inputPlayer.getPlayerSelectedBattle().getBattleMonster().getMonsterHealthLevel() <= 0) {
				return FightOutcomeType.PLAYER_WINS_BATTLE;
			} else {
				inputPlayer.getPlayerSelectedBattle().setCurrentChallenge(this.makeRandomChallenge());
				return FightOutcomeType.BOTH_MONSTERS_STILL_HAVE_HEALTH;
			}
		} else {
			inputPlayer.getPlayerInventory().getMonsters().remove(0);

			if (inputPlayer.getPlayerInventory().getMonsters().size() > 0) {
				inputPlayer.getPlayerSelectedBattle().setCurrentChallenge(this.makeRandomChallenge());
				return FightOutcomeType.PLAYER_LOSES_MONSTER_BUT_BATTLE_CONTINUES;
			} else {
				return FightOutcomeType.PLAYER_OUT_OF_MONSTERS_AND_LOSES_BATTLE_GAME_OVER;
			}
		}
	}
	
	public String generateChallengeResultMessage(ChallengeOutcomeType inputChallengeOutcomeType) {
		
		switch (inputChallengeOutcomeType) {
		
		case WIN:
			return "You win the challenge!";
		case LOSE:
			return "You've lost the challenge...";
		default:
			return "It was a draw. You and the boss monster got the same thing.";
		}
	}



	public String runRandomOvernightEvent(Player inputPlayer) {
		int randNumber = random.nextInt(1, 11);
		String message = "";
		if (inputPlayer.getPlayerInventory().getLottoTicket() != null) {
			if (inputPlayer.getPlayerInventory().getLottoTicket().getLottoTicketNumber() == randNumber) {
				randomGoodThingOvernight(inputPlayer);
			}
		} else if (randNumber == 11) {
			message = randomGoodThingOvernight(inputPlayer);
		} else if (randNumber == 6) {
			message = randomBadThingOvernight(inputPlayer);
		}
		return message;
	}

	public String randomGoodThingOvernight(Player inputPlayer) {
		int randomNumber = random.nextInt(1, 3);
		switch (randomNumber) {
			case 1:
				if (inputPlayer.getPlayerInventory().getMonsters().size() >= howManyMonstersBasedOnDifficulty(inputPlayer.getPlayerDifficulty())) {
					int randomNumber2 = random.nextInt(2, 4);
					for (int index = 0; index < randomNumber2; index++) {
						inputPlayer.getPlayerInventory().addFood(new Food(FoodType.PASTA));
					}
					return (String.format("Wow! You found a food bag of %d food items! Open inventory to see new foods.", randomNumber2));
				} else {
					Monster monster = this.generateRandomMonster(inputPlayer);
					monster.setEntityName(magicNumbers.RANDOM_MONSTER_NAMES[random.nextInt(0, magicNumbers.RANDOM_MONSTER_NAMES.length)]);
					inputPlayer.getPlayerInventory().addMonster(monster);
					return String.format("A new monster, %s,joined your team overnight! Open inventory to view it.", monster.getEntityName());
				}
			case 2:
				int randomNumber2 = random.nextInt(2, 4);
				for (int index = 0; index < randomNumber2; index++) {
					inputPlayer.getPlayerInventory().addFood(new Food(FoodType.PASTA));
				}
				return (String.format("Wow! You found a food bag of %d food items! Open inventory to see new foods.", randomNumber2));
			default:
				Monster monsterWithLowestHealthLevel = inputPlayer.getPlayerInventory().getMonsters().get(0);
				for (int index = 1; index < inputPlayer.getPlayerInventory().getMonsters().size(); index++) {
					if (inputPlayer.getPlayerInventory().getMonsters().get(index).getMonsterHealthLevel() < monsterWithLowestHealthLevel.getMonsterHealthLevel()) {
						monsterWithLowestHealthLevel = inputPlayer.getPlayerInventory().getMonsters().get(index);
					}
				}
				monsterWithLowestHealthLevel.resetMonsterHealthLevel();
				return (String.format("%s had the lowest health level in your team, but it found a bag full of food overnight. It has eaten so much that its health is now 100%", monsterWithLowestHealthLevel.getEntityName()));
		}
	}

	public String randomBadThingOvernight(Player inputPlayer) {
		return "";
	}

	public String[] getMonsterNames(Player inputPlayer) {
		ArrayList<Monster> monsters = inputPlayer.getPlayerInventory().getMonsters();
		ArrayList<String> monsterNameArrayList= new ArrayList<>();

		for (Monster monster : monsters) {
			monsterNameArrayList.add(monster.getEntityName());
		}

		return (String[]) monsterNameArrayList.toArray();
	}
}
