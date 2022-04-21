package monsters;

import assets.MagicNumbers;
import exceptions.UnallowedMethodException;
import main.Player;

public class Monster {

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

    private int healthLevel;

    void setHealthLevel(int inputHealthLevel) {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    void resetHealthLevel() {

    }

    private int attackDamage;
    private int resistanceAbility;

    // IMPORTANT VARIABLES --------------------------------------------------


    // INSTANTIATION --------------------------------------------------------

    Monster(Player player) {
        magicNumbers = new MagicNumbers(player.getDifficultyLevel());
    }

    // INSTANTIATION --------------------------------------------------------
}
