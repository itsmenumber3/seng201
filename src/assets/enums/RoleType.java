package assets.enums;

/**
 * This enum type allows for any class as implemented from interface Role to identify itself with a role.
 * There are three values: PLAYER, SHOP, MONSTER.
 * @see main.Role the Role interface
 * @see main.Player the Player class using PLAYER
 * @see main.Shop the Shop class using SHOP
 * @see entities.monsters.Monster the Monster class using MONSTER
 */
public enum RoleType {
    PLAYER,
    SHOP,
    MONSTER,
    TEAM
}
