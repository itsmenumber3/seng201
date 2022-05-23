package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class GrassMonster extends Monster {
	
	/**
	 * Constructor for grass monster, sets default values.
	 * Monster type is set as grass monster
	 */
    public GrassMonster() {
        this.setMonsterType(MonsterType.GRASS_MONSTER);
    }
}
