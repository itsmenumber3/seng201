package assets.enums;

/**
 * The enumerator of the possible outcomes of a fight (after a challenge has been completed).
 * Enumerates the list of possible outcomes.
 */
public enum FightOutcomeType {
    PLAYER_LOSES_MONSTER_BUT_BATTLE_CONTINUES,
    PLAYER_OUT_OF_MONSTERS_AND_LOSES_BATTLE_GAME_OVER,
    PLAYER_WINS_BATTLE,
    BOTH_MONSTERS_STILL_HAVE_HEALTH
}
