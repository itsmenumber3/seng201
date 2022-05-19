package battles;

import assets.enums.BattleType;

public class MountCook extends Battle {
    public MountCook() {
    	this.setBattleName("Mount Cook");
        this.setBattleType(BattleType.MOUNT_COOK);
        this.getBattleShop().setShopName("Four Square Tekapo");
    }
}
