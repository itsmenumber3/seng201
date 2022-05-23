package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Skeleton extends Monster {
	
	/**
	 * Constructor for Skeleton, sets default values.
	 * Monster type and entity name is set as Skeleton
	 * The image path is for the use in icons
	 */
	public Skeleton() {
		this.setMonsterType(MonsterType.SKELETON);
		this.setEntityImagePath("/assets/ui/img/skeleton-final.jpg");
		this.setEntityName("Skeleton");
	}
}
