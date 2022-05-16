package main.gameplay.battles;

import assets.enums.BattleSetting;

public class SeasideVillage extends Battle {
    public SeasideVillage(String inputBattleName, String inputBattleDescription) {
        this.setBattleName(inputBattleName);
        this.setBattleDescription(inputBattleDescription);
        this.setBattleSetting(BattleSetting.SEASIDE_VILLAGE);
    }
}
