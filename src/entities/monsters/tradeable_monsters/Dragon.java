package entities.monsters.tradeable_monsters;
import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Dragon extends Monster {
	
    public Dragon() {
    	this.setMonsterType(MonsterType.DRAGON);
    	this.setEntityImagePath("/assets/ui/img/dragon-final.png");
    	this.setEntityName("Dragon");
    }
	
}	
