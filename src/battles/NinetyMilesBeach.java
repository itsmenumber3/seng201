package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;

public class NinetyMilesBeach extends Battle {
	
    public NinetyMilesBeach() {
    	this.setBattleName("90 Miles Beach");
        this.setBattleType(BattleType.NINETY_MILES_BEACH);
        this.getBattleShop().setShopName("Pak'nSAVE Kaitaia");
    }
}
