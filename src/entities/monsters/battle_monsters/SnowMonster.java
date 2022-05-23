package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class SnowMonster extends Monster {
	
	/**
	 * Constructor for snow monster, sets default values.
	 * Monster type is set as snow monster
	 */
    public SnowMonster() {
        this.setMonsterType(MonsterType.SNOW_MONSTER);
    }
}
