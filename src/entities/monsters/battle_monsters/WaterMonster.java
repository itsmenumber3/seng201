package entities.monsters.battle_monsters;

import assets.enums.MonsterType;
import entities.monsters.Monster;

public class WaterMonster extends Monster {
    public WaterMonster() {
        this.setMonsterType(MonsterType.WATER_MONSTER);
    }
}
