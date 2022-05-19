package battles;

import assets.enums.BattleType;

public class LakeTaupo extends Battle {
    public LakeTaupo() {
    	this.setBattleName("Lake Taupo");
        this.setBattleType(BattleType.LAKE_TAUPO);
        this.getBattleShop().setShopName("The Warehouse Taupo");
    }
}
