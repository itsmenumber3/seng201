package main.gameplay.battles;

import assets.enums.BattleSetting;

public class Antarctica extends Battle {
    public Antarctica(String inputBattleName, String inputBattleDescription) {
        this.setBattleName(inputBattleName);
        this.setBattleDescription(inputBattleDescription);
        this.setBattleSetting(BattleSetting.ANTARCTICA);
    }
}
