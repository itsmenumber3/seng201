package entities.items.consumables;

import entities.items.Item;
import java.security.SecureRandom;

public class Drink extends Consumable {
	
	private int healthIncrease;
	
	
    public Drink(int inputDrinkType) {
        super();
        generateDrink(inputDrinkType);
    }
    
    private void generateDrink(int inputDrinkType) {
    	if (inputDrinkType == 1) {
    		super.setEntityName("Coffee");
    		super.setEntitySellValue(magicNumbers.COFFEE_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.COFFEE_SELL_VALUE, magicNumbers.COFFEE_SELL_VALUE + magicNumbers.DRINK_VAR));
    		
    	}
    	else {
    		super.setEntityName("Energy Drink");
    		super.setEntitySellValue(magicNumbers.ENERGY_DRINK_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.ENERGY_DRINK_SELL_VALUE, magicNumbers.ENERGY_DRINK_SELL_VALUE + magicNumbers.DRINK_VAR));
    	}
    }

	public int getHealthIncrease() {
		return healthIncrease;
	}


	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
}
