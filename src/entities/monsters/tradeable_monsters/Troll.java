package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Troll extends Monster {
	
	/**
	 * Constructor for Troll, sets default values.
	 * Monster type and entity name is set as Troll
	 * The image path is for the use in icons
	 */
	public Troll() {
		this.setMonsterType(MonsterType.TROLL);
		this.setEntityImagePath("/assets/ui/img/troll-final.png");
		this.setEntityName("Troll");
		}
}
