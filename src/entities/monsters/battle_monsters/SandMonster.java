package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class SandMonster extends Monster {
	
	/**
	 * Constructor for sand monster, sets default values.
	 * Monster type is set as sand monster
	 */
    public SandMonster() {
        this.setMonsterType(MonsterType.SAND_MONSTER);
    }
}
