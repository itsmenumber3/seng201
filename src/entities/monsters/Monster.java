package entities.monsters;

import assets.enums.MonsterType;
import assets.enums.RoleType;
import entities.Entity;
import exceptions.InvalidMonsterNumericPropertyException;
import exceptions.UnallowedMethodException;
import main.Role;

public class Monster extends Entity implements Role {
	

	private RoleType roleType = RoleType.MONSTER; // This is the role type of the monster 
    private MonsterType monsterType; // This is the type of monster that is being represented
    private double monsterHealthLevel; // This is the current health level of the monster
    private double monsterAttackDamage; // This is the damage caused by the monster on its opponent
    private double monsterResistanceAbility; // This is the resistance to an attack that the monster has

    /** Setter of the roleType
    *This is an unallowed method and will throw the UnallowedMethodException exception
    *It will return "unallowed method" to the stack
    */
	public void setRoleType(RoleType inputRoleType) {
		try {
			throw new UnallowedMethodException("unallowed method");
		} catch (UnallowedMethodException e) {
			e.printStackTrace();
		}
	}
	
    /** Getter the roleType of the Monster
    * This method returns the role type of the monster
    * @return roleType: RoleType
    */
    public RoleType getRoleType() {
        return this.roleType;
    }
    
    /** Setter for the monsterType of Monster
    * This method sets the monsters type
    * @param inputMonsterType
    * @return monsterType: MonsterType
    */
    public void setMonsterType(MonsterType inputMonsterType) {
    	this.monsterType = inputMonsterType;
    }
    
    /** Getter for the monsterType of the Monster'
    * This method returns the monsters type
    * @return monsterType: MonsterType
    */
    public MonsterType getMonsterType() {
    	return this.monsterType;
    }


//    // INSTANTIATION --------------------------------------------------------
//
//    /**
//     * This method will create an instance of the class Monster.
//     * @param inputEntityName String, the name of the monster
//     * @param inputEntityRarity Rarity, the rarity of the monster
//     * @param inputEntityPurchaseValue
//     * @param inputEntitySellValue
//     * @param inputAttackDamage
//     * @param inputResistanceAbility
//     * @param inputHealAmount
//     * @see Rarity
//     */
//    public Monster(String inputEntityName, int inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue,
//                   int inputAttackDamage, int inputResistanceAbility) {
//        super(inputEntityName, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
//        this.resetMonsterHealthLevel();
//        this.setMonsterAttackDamage(inputAttackDamage);
//        this.setMonsterResistanceAbility(inputResistanceAbility);
//    }
//
//    // INSTANTIATION --------------------------------------------------------



    // HEALTH LEVEL ---------------------------------------------------

    /** Setter for the monsterHealthLevel
     * This method isn't allowed and will throw an error.
     * @param inputMonsterHealthLevel: integer
     */
    public void setMonsterHealthLevel(int inputMonsterHealthLevel) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /** Restter for the getMonsterHealthLevel 
     * This method resets the health level to DEFAULT_HEALTH_LEVEL in MagicNumbers
     * The current health level is checked to see if it is within range
     * @see assets.libraries.MagicNumbers
     */
    public void resetMonsterHealthLevel() {
        try {
            if (magicNumbers.DEFAULT_MONSTER_HEALTH_LEVEL <= magicNumbers.MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE  && magicNumbers.DEFAULT_MONSTER_HEALTH_LEVEL >= magicNumbers.MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE) {
                this.monsterHealthLevel = magicNumbers.DEFAULT_MONSTER_HEALTH_LEVEL;
            } else {
                throw new InvalidMonsterNumericPropertyException("Health over 100");
            }
        } catch (InvalidMonsterNumericPropertyException e) {
            System.out.println("Invalid monster health!");
        }
    }

    /** Getter for the monsterHealthLevel
     * This method returns the health level
     * @return monsterHealthLevel: integer
     */
    public double getMonsterHealthLevel() {
        return this.monsterHealthLevel;
    }

    public void increaseMonsterHealthLevel(double inputIncreaseAmount) {
        this.monsterHealthLevel += inputIncreaseAmount;
    }

    public void monsterGetsAttacked(double inputOpponentAttackDamage) {
        this.monsterHealthLevel = this.monsterHealthLevel - (inputOpponentAttackDamage * ((100 - this.monsterResistanceAbility) / 100));
    }



    // HEALTH LEVEL ---------------------------------------------------
    
    
    
    // ATTACK DAMAGE --------------------------------------------------

    /** Setter for the monsterAttackDamage
     * This method sets the attack damage ability
     * @param inputMonsterAttackDamage
     */
    public void setMonsterAttackDamage(double inputMonsterAttackDamage) {
        try {
            if (inputMonsterAttackDamage <= magicNumbers.MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE  && inputMonsterAttackDamage >= magicNumbers.MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE) {
                this.monsterAttackDamage = inputMonsterAttackDamage;
            } else {
                throw new InvalidMonsterNumericPropertyException("Over 100!");
            }
        } catch (InvalidMonsterNumericPropertyException e) {
            e.printStackTrace();
        }

    }

    /** Getter for the monsterAttackDamage
     * This method returns the monster attack damage
     * @return monsterAttackDamage: integer
     */
    public double getMonsterAttackDamage() {
        return this.monsterAttackDamage;
    }
    // ATTACK DAMAGE --------------------------------------------------


    
    // RESISTANCE ABILITY ---------------------------------------------------

    /** Setter for the monsterResistanceAbility
    * This method sets the resistance of a monster from an attack
    * @param inputResistanceAbility
    */
    public void setMonsterResistanceAbility(double inputResistanceAbility) {
        try {
            if (inputResistanceAbility <= magicNumbers.MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE && inputResistanceAbility >= magicNumbers.MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE) {
                this.monsterResistanceAbility = inputResistanceAbility;
            } else {
                throw new InvalidMonsterNumericPropertyException("Invalid numeric value");
            }
        } catch (InvalidMonsterNumericPropertyException e) {
            e.printStackTrace();
        }
        this.monsterResistanceAbility = inputResistanceAbility;
    }

    /** Getter for the monsterResistanceAbility
     * This method returns the resistance ability of the monster from an attack
     * @return monsterResistanceAbility: integer
     */
    public double getMonsterResistanceAbility() {
        return this.monsterResistanceAbility;
    }

    // RESISTANCE ABILITY ---------------------------------------------------
}
