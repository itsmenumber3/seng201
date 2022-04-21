package monsters;

import main.Player;

public class Skeleton extends Monster {
    public Skeleton(Player player) {
        super(player);
        this.setMonsterValue(magicNumbers.SKELETON_VALUE);
    }
}
