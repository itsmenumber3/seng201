package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;
import main.Player;

public class Skeleton extends Monster {
	public Skeleton() {
		this.setMonsterType(MonsterType.SKELETON);
		super.setEntityImagePath("/assets/ui/img/skeleton-final.png");
	}
}
