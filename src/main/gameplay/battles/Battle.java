package main.gameplay.battles;

import assets.enums.BattleSetting;

/**
 * The class Battle provides functionalities to play the game.
 */
public class Battle {

    // BATTLE SETTING ---------------------------------------------

    public BattleSetting battleSetting;

    // BATTLE SETTING ---------------------------------------------

    public void setBattleSetting(BattleSetting inputBattleSetting) {
        this.battleSetting = inputBattleSetting;
    }

    public BattleSetting getBattleSetting() {
        return this.battleSetting;
    }

    public String battleName;

    public void setBattleName(String inputBattleName) {
        this.battleName = inputBattleName;
    }

    public String getBattleName() {
        return this.battleName;
    }

    public String battleDescription;

    public void setBattleDescription(String inputBattleDescription) {
        this.battleDescription = inputBattleDescription;
    }

    public String getBattleDescription() {
        return this.battleDescription;
    }
}
