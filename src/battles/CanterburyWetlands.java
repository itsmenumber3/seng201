package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class CanterburyWetlands extends Battle {
	private Tools tools = new Tools();
	
	public CanterburyWetlands(Player player) {
		this.setBattleName("Canterbury Wetlands");
		this.setBattleType(BattleType.CANTERBURY_WETLANDS);
		this.getBattleShop().setShopName("New World Kaikoura");
		this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
	}

}
