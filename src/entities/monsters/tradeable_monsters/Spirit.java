package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Spirit extends Monster {
	public Spirit() {
		this.setMonsterType(MonsterType.SPIRIT);
		super.setEntityImagePath("/assets/ui/img/spirit-final.png");
	}
}
