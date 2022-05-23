package entities.monsters.tradeable_monsters;
import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Dragon extends Monster {
	
	/**
	 * Constructor for Dragon, sets default values.
	 * Monster type and entity name is set as Dragon
	 * The image path is for the use in icons
	 */
    public Dragon() {
    	this.setMonsterType(MonsterType.DRAGON);
    	this.setEntityImagePath("/assets/ui/img/dragon-final.png");
    	this.setEntityName("Dragon");
    }
	
}	
