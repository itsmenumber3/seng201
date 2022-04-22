package entities.monsters;

import assets.enums.Rarity;
import assets.enums.RoleType;
import entities.Entity;
import exceptions.InvalidMonsterNumericPropertyException;
import exceptions.UnallowedMethodException;
import main.Role;

public abstract class Monster extends Entity implements Role {

    // LOGGING FUNCTION ----------------------------------------------------

    /**
     * This method is an implementation of the abstract method as defined in interface Role.
     * It returns a RoleType enum data. It is used in the logging feature of this game.
     * @see Role
     * @see RoleType
     * @return RoleType.MONSTER
     */
    @Override
    public RoleType getRoleType() {
        return RoleType.MONSTER;
    }

    // LOGGING FUNCTION ----------------------------------------------------



    // INSTANTIATION --------------------------------------------------------

    /**
     * This method will create an instance of the class Monster.
     * @param inputEntityName String, the name of the monster
     * @param inputEntityDescription String, the description of the monster
     * @param inputEntityRarity Rarity, the rarity of the monster
     * @param inputEntityPurchaseValue
     * @param inputEntitySellValue
     * @param inputAttackDamage
     * @param inputResistanceAbility
     * @see Rarity
     */
    public Monster(String inputEntityName, String inputEntityDescription, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue,
                   int inputAttackDamage, int inputResistanceAbility) {
        super(inputEntityName, inputEntityDescription, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);
        this.resetMonsterHealthLevel();
        this.setMonsterAttackDamage(inputAttackDamage);
        this.setMonsterResistanceAbility(inputResistanceAbility);
    }

    // INSTANTIATION --------------------------------------------------------



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
     * This method set the attack damage ability
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
    // ATTACK DAMAGE --------------------------------------------------


    
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
}
