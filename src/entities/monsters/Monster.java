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

    // ROLE TYPE --------------------------------------------------
    /** This method is not allowed.
     *  will throw the UnallowedMethodException exception
    */
	public void setRoleType(RoleType inputRoleType) {
		try {
			throw new UnallowedMethodException("unallowed method");
		} catch (UnallowedMethodException e) {
			e.printStackTrace();
		}
    };
    
    /** Getter for the monsterType of the Monster'
    * This method returns the monsters type
    * @return monsterType: MonsterType
    */
    public MonsterType getMonsterType() {
    	return monsterType;
    }
    // MONSTER TYPE -----------------------------------------------

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
                monsterHealthLevel = magicNumbers.DEFAULT_MONSTER_HEALTH_LEVEL;
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
        return monsterHealthLevel;
    }

    public void increaseMonsterHealthLevel(double inputIncreaseAmount) {
        monsterHealthLevel += inputIncreaseAmount;
    }

    public void monsterGetsAttacked(double inputOpponentAttackDamage) {
        monsterHealthLevel = monsterHealthLevel - (inputOpponentAttackDamage * ((100 - monsterResistanceAbility) / 100));
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
                monsterAttackDamage = inputMonsterAttackDamage;
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
        return monsterAttackDamage;
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
                monsterResistanceAbility = inputResistanceAbility;
            } else {
                throw new InvalidMonsterNumericPropertyException("Invalid numeric value");
            }
        } catch (InvalidMonsterNumericPropertyException e) {
            e.printStackTrace();
        }
        monsterResistanceAbility = inputResistanceAbility;
    }

    /** Getter for the monsterResistanceAbility
     * This method returns the resistance ability of the monster from an attack
     * @return monsterResistanceAbility: integer
     */
    public double getMonsterResistanceAbility() {
        return monsterResistanceAbility;
    }

    // RESISTANCE ABILITY ---------------------------------------------------
}
