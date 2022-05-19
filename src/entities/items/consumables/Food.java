package entities.items.consumables;

import entities.items.Item;
import java.security.SecureRandom;

public class Food extends Consumable {
	SecureRandom random = new SecureRandom();
	
	private int healthIncrease;
	
    public Food(int inputFoodType) {
        super();
        generateFood(inputFoodType);
    }
    
    private void generateFood(int inputFoodType) {
    	if (inputFoodType == 1) {
    		super.setEntityName("Pasta");
    		super.setEntitySellValue(magicNumbers.PASTA_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.PASTA_SELL_VALUE, magicNumbers.PASTA_SELL_VALUE + magicNumbers.FOOD_VAR));
    		
    	}
    	else {
    		super.setEntityName("Apple");
    		super.setEntitySellValue(magicNumbers.APPLE_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.APPLE_SELL_VALUE, magicNumbers.APPLE_SELL_VALUE + magicNumbers.FOOD_VAR));
    	}
    }

	public int getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
}
