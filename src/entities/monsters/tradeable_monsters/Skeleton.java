package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Skeleton extends Monster {
	public Skeleton() {
		this.setMonsterType(MonsterType.SKELETON);
		this.setEntityImagePath("/assets/ui/img/skeleton-final.png");
	}
}
