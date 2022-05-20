package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class MountCook extends Battle {
	private Tools tools = new Tools();
	
    public MountCook(Player player) {
    	this.setBattleName("Mount Cook");
        this.setBattleType(BattleType.MOUNT_COOK);
        this.setBattleIsland("North Island");
        this.getBattleShop().setShopName("Four Square Tekapo");
		this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
    }
}
