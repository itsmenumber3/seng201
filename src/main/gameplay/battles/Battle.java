package main.gameplay.battles;

import assets.enums.BattleSetting;

/**
 * The class Battle provides functionalities to play the game.
 */
public abstract class Battle {

    // BATTLE SETTING ---------------------------------------------

    /**
     * BattleSetting is where the battle takes place.
     * @see see BattleSetting.java in package assets/enums/ for more
     */
    private BattleSetting battleSetting;

    /**
     * This method sets the setting of the battle (e.g. THE_OUTBACK)
     * @param inputBattleSetting BattleSetting (see BattleSetting.java in package assets/enums/)
     */
    public void setBattleSetting(BattleSetting inputBattleSetting) {
        this.battleSetting = inputBattleSetting;
    }

    /**
     * This method returns the setting of the battle (e.g. THE_OUTBACK)
     * @return this.battleSetting the setting of the battle
     */
    public BattleSetting getBattleSetting() {
        return this.battleSetting;
    }

    // BATTLE SETTING ---------------------------------------------

    // BATTLE NAME ------------------------------------------------

    /**
     * This string stores the name of the battle
     */
    private String battleName;

    /**
     * This method sets the name of the battle
     * @param inputBattleName String the name of the battle
     */
    public void setBattleName(String inputBattleName) {
        this.battleName = inputBattleName;
    }

    /**
     * This method returns the name of the battle
     * @return battleName String
     */
    public String getBattleName() {
        return this.battleName;
    }

    // BATTLE NAME ------------------------------------------------


    // BATTLE DESCRIPTION -----------------------------------------

    /**
     * This string stores a short description of the battle.
     */
    private String battleDescription;

    /**
     * This method sets the description of the battle.
     * @param inputBattleDescription String
     */
    public void setBattleDescription(String inputBattleDescription) {
        this.battleDescription = inputBattleDescription;
    }

    /**
     * This method returns the description of the battle.
     * @return this.battleDescription String
     */
    public String getBattleDescription() {
        return this.battleDescription;
    }

    // BATTLE DESCRIPTION -----------------------------------------
}
