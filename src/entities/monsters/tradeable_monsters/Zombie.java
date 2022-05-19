package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Zombie extends Monster {
	public Zombie() {
		this.setMonsterType(MonsterType.ZOMBIE);
		this.setEntityImagePath("/assets/ui/img/zombie-final.png");
	}
}
