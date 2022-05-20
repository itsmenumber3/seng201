package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class SouthlandFarm extends Battle {
	private Tools tools = new Tools();
	
    public SouthlandFarm(Player player) {
    	this.setBattleName("Southland Farm");
    	this.setBattleIsland("South Island");
        this.setBattleType(BattleType.SOUTHLAND_FARM);
        this.getBattleShop().setShopName("Countdown Gore");
		this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
    }
}
