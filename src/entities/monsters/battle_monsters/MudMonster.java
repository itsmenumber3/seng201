package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class MudMonster extends Monster {
	
	/**
	 * Constructor for mud monster, sets default values.
	 * Monster type is set as mud monster
	 */
    public MudMonster() {
        setMonsterType(MonsterType.MUD_MONSTER);
    }
}
