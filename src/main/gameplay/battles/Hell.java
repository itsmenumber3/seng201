package main.gameplay.battles;

import assets.enums.BattleSetting;

public class Hell extends Battle {
    public Hell(String inputBattleName, String inputBattleDescription) {
        this.setBattleName(inputBattleName);
        this.setBattleDescription(inputBattleDescription);
        this.setBattleSetting(BattleSetting.HELL);
    }
}
