# Monster Fighter

## Developers' Notes


### Introduction
* Monster Fighter was developed by Francis Phan and Jonathan Nicholas for SENG201.
  https://go.codetogether.com/#/gQdcSMg2hb5n9JzX066808/za5lj5dO9gXbMBX24XTfca

  this is a lot more powerful than is otherwise needed!
### Development timeline

* Small changes

### How entities, the player, and the shop interact in a nutshell
A monster cannot fight on its own, however it has its own health level which is personally reduced if attacked by the opponent monster – depending on their resistance ability which is randomly generated.

As for that monster it must use a weapon to fight. A weapon is specific to a monster, for example only arrows can be used by the skeleton.

The only exception to this rule is the shield which can be applied to any monster, but it is not used to fight but rather to protect the monster with increased resistance ability.

Being out of weapons (except for shield) means the monster loses the ability to attack. The player must switch to a new monster. If no monster with weapon is available left, this means the battle is lost.

The attack damage caused by the weapon remains the same throughout the game (not randomly generated)

The shop has unlimited stock of items (food, potion, and weapons) which means if the player buys items, it does not affect stock.

The shop does have physically limited stock of monsters. On a new day this is reset to 10 monsters on sale. If the player sells a monster back to the shop, this increases to 11 (this should still be reset to 10 the following day). If instead the player buys a monster this is reduced to 9.

The player isn't allowed to "swap" monsters with the shop. They must sell it back to the shop, and then buy the new monster.

## Game explanation

* There are four kinds of monsters (nothing to see here)

## Some features
* All entities.monsters have the same amount of health out of 100
* They differ in their ability to resist damage

## An explanation of the file structure
* /src/ is the source root of the game program.
* Game is the main class that co-ordinates the game.
* MagicNumbers stores constants 



