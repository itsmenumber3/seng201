package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class SnowMonster extends Monster {
    public SnowMonster() {
        this.setMonsterType(MonsterType.SNOW_MONSTER);
    }
}
