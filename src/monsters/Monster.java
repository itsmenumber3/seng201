package monsters;

import assets.MagicNumbers;
import exceptions.InvalidMonsterNumericPropertyException;
import exceptions.UnallowedMethodException;
import main.Entity;
import main.Player;

public class Monster extends Entity {

    // LIBRARIES ------------------------------------------------------------

    MagicNumbers magicNumbers = new MagicNumbers();


    // LIBRARIES ------------------------------------------------------------



    // MONSTER VALUE --------------------------------------------------

    private int monsterValue;

    /**
     * This method sets the gold value of the monster.
     * @param inputMonsterValue: integer
     */
    void setMonsterValue(int inputMonsterValue) {
        this.monsterValue = inputMonsterValue;
    }

    /**
     * This method returns the gold value of the monster.
     * @return monsterValue: integer
     */
    public int getMonsterValue() {
        return this.monsterValue;
    }

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
            if (magicNumbers.DEFAULT_MONSTER_HEALTH_LEVEL <= 100) {
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
            if (inputMonsterAttackDamage <= 100) {
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
    
    
    private int resistanceAbility;

    // IMPORTANT VARIABLES --------------------------------------------------


    // INSTANTIATION --------------------------------------------------------

    Monster(Player player) {
        magicNumbers = new MagicNumbers(player.getDifficultyLevel());
    }

    // INSTANTIATION --------------------------------------------------------
}
