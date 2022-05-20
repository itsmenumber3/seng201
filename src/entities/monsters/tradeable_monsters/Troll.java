package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Troll extends Monster {
	public Troll() {
		this.setMonsterType(MonsterType.TROLL);
		this.setEntityImagePath("/assets/ui/img/troll-final.png");
		this.setEntityName("Troll");
		}
}
