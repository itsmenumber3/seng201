package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class MudMonster extends Monster {
    public MudMonster() {
        setMonsterType(MonsterType.MUD_MONSTER);
    }
}
