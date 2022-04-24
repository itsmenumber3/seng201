package assets.libraries;

import entities.items.consumables.Food;
import entities.items.consumables.Potion;
import entities.items.weapons.ArrowBatch;
import entities.items.weapons.BulletBatch;

import java.util.Random;

/**
 * Generator class has a number of specialised functionalities with regard to:
 * 1. Generating new items (as objects) in shops based on the classes implemented.
 * 2. Generating new opponents in the battle.
 * 3. Generating random events that can happen overnight.
 */
public class Generator {
    Random random = new Random();

    public int generateRandomInteger(int inputUpperBound) {
        return random.nextInt(inputUpperBound);
    }

    public Food generateNewFood() {

    }

    public Potion generateNewPotion() {

    }

    public ArrowBatch generateNewArrowBatch() {

    }

    public BulletBatch generateNewBulletBatch() {

    }


}
