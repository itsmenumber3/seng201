package main.gameplay.battles;

import assets.enums.BattleSetting;

public class TheOutback extends Battle {
    public TheOutback(String inputBattleName, String inputBattleDescription) {
        this.setBattleName(inputBattleName);
        this.setBattleDescription(inputBattleDescription);
        this.setBattleSetting(BattleSetting.THE_OUTBACK);
    }
}
