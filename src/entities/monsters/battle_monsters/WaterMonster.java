package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class WaterMonster extends Monster {
	
	/**
	 * Constructor for water monster, sets default values.
	 * Monster type is set as water monster
	 */
    public WaterMonster() {
        this.setMonsterType(MonsterType.WATER_MONSTER);
    }
}
