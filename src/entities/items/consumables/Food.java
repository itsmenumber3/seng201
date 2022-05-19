package entities.items.consumables;

import assets.enums.FoodType;
import java.security.SecureRandom;

public class Food extends Consumable {
	SecureRandom random = new SecureRandom();
	
	private int healthIncrease;
	private FoodType foodType;
	
	
    public Food(FoodType inputFoodType) {
        super();
        generateFood(inputFoodType);
    }
    
    private void generateFood(FoodType inputFoodType) {
    	if (inputFoodType == FoodType.PASTA) {
    		setFoodType(inputFoodType);
    		super.setEntityName("Pasta");
    		super.setEntitySellValue(magicNumbers.PASTA_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.PASTA_SELL_VALUE, magicNumbers.PASTA_SELL_VALUE + magicNumbers.FOOD_VAR));	
    	}
    	else {
    		setFoodType(inputFoodType);
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

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}
