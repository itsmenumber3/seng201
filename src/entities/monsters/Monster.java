package entities.monsters;

import assets.MagicNumbers;
import exceptions.InvalidMonsterNumericPropertyException;
import exceptions.UnallowedMethodException;
import entities.Entity;
import main.Player;

public class Monster extends Entity {

    // LIBRARIES ------------------------------------------------------------

    MagicNumbers magicNumbers = new MagicNumbers();


    // LIBRARIES ------------------------------------------------------------



    // MONSTER VALUE --------------------------------------------------
// DEPRECATED
//    private int monsterValue;
//
//    /**
//     * This method sets the gold value of the monster.
//     * @param inputMonsterValue: integer
//     */
//    void setMonsterValue(int inputMonsterValue) {
//        this.monsterValue = inputMonsterValue;
//    }
//
//    /**
//     * This method returns the gold value of the monster.
//     * @return monsterValue: integer
//     */
//    public int getMonsterValue() {
//        return this.monsterValue;
//    }

    // MONSTER VALUE --------------------------------------------------



    // HEALTH LEVEL ---------------------------------------------------

    private int monsterHealthLevel;

    /**
     * This method isn't allowed and will throw an error.
     * @param inputMonsterHealthLevel: integer
     */
    void setMonsterHealthLevel(int inputMonsterHealthLevel) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method resets the health level to DEFAULT_HEALTH_LEVEL in MagicNumbers
     */
    void resetMonsterHealthLevel() {
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

    /**
     * This method returns the health level
     * @return monsterHealthLevel: integer
     */
    public int getMonsterHealthLevel() {
        return this.monsterHealthLevel;
    }

    // HEALTH LEVEL ---------------------------------------------------
    
    
    
    // ATTACK DAMAGE --------------------------------------------------

    private int monsterAttackDamage; // THis is the damage caused by the monster on its opponent

    /**
     * This methods set the attack damage ability
     * @param inputMonsterAttackDamage: integer
     */
    void setMonsterAttackDamage(int inputMonsterAttackDamage) {
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

    /**
     * This method returns the monster attack damage
     * @return monsterAttackDamage: integer
     */
    public int getMonsterAttackDamage() {
        return this.monsterAttackDamage;
    }
    
    // RESISTANCE ABILITY ---------------------------------------------------

    private int monsterResistanceAbility;

    void setMonsterResistanceAbility(int inputResistanceAbility) {
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

    /**
     * This method returns the resistance ability of the monster
     * @return monsterResistanceAbility: integer
     */
    public int getMonsterResistanceAbility() {
        return this.monsterResistanceAbility;
    }

    // RESISTANCE ABILITY ---------------------------------------------------

    // IMPORTANT VARIABLES --------------------------------------------------


    // INSTANTIATION --------------------------------------------------------

    Monster(Player player) {
        magicNumbers = new MagicNumbers(player.getPlayerDifficulty());
    }

    // INSTANTIATION --------------------------------------------------------
}
