package battles;

import assets.enums.BattleType;
import assets.libraries.Tools;
import main.Player;

public class SouthlandFarm extends Battle {

    public SouthlandFarm(Player player) {
    	this.setBattleName("Southland Farm");
    	this.setBattleIsland("South Island");
        this.setBattleType(BattleType.SOUTHLAND_FARM);
        this.getBattleShop().setShopName("Countdown Gore");
        Tools tools = new Tools();
        this.getBattleShop().setShopMonsterRange(tools.generateManyRandomMonsters(player, 5));
        this.setBattleImagePath("/assets/ui/img/SouthlandFarm.jpg");
		this.getBattleShop().setShopDrinkRange();
		this.getBattleShop().setShopFoodRange();
    }
}
