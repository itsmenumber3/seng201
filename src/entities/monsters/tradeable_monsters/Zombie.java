package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Zombie extends Monster {
	
	/**
	 * Constructor for Zombie, sets default values.
	 * Monster type and entity name is set as Zombie
	 * The image path is for the use in icons
	 */
	public Zombie() {
		this.setMonsterType(MonsterType.ZOMBIE);
		this.setEntityImagePath("/assets/ui/img/zombie-final.jpg");
		this.setEntityName("Zombie");
	}
}
