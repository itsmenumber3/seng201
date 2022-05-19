package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class LakeTaupo extends Battle {
	private Tools tools = new Tools();
	
    public LakeTaupo(Player player) {
    	this.setBattleName("Lake Taupo");
        this.setBattleType(BattleType.LAKE_TAUPO);
        this.getBattleShop().setShopName("The Warehouse Taupo");
		this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
    }
}
