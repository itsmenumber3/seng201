package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class NinetyMilesBeach extends Battle {
	private Tools tools = new Tools();
	
    public NinetyMilesBeach(Player player) {
    	this.setBattleName("90 Miles Beach");
    	this.setBattleIsland("North Island");
        this.setBattleType(BattleType.NINETY_MILES_BEACH);
        this.getBattleShop().setShopName("Pak'nSAVE Kaitaia");
		this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
        this.setBattleImagePath("/assets/ui/img/NinetyMilesBeach.jpg");
    }
}
