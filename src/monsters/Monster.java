package monsters;

import assets.MagicNumbers;
import main.Player;

public class Monster {

    // LIBRARIES ------------------------------------------------------------
    MagicNumbers magicNumbers = new MagicNumbers();
    int monsterValue;

    // LIBRARIES ------------------------------------------------------------



    // INSTANTIATION --------------------------------------------------------

    Monster(Player player) {
        magicNumbers = new MagicNumbers(player.getDifficultyLevel());
    }

    // INSTANTIATION --------------------------------------------------------
}
