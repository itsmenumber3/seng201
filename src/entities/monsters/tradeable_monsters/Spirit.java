package entities.monsters.tradeable_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Spirit extends Monster {
	
	/**
	 * Constructor for Spirit, sets default values.
	 * Monster type and entity name is set as Spirit
	 * The image path is for the use in icons
	 */
	public Spirit() {
		this.setMonsterType(MonsterType.SPIRIT);
		this.setEntityImagePath("/assets/ui/img/spirit-final.jpg");
		this.setEntityName("Spirit");
	}
}
