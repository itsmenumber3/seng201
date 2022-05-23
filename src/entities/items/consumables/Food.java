package entities.items.consumables;

import assets.enums.FoodType;
import java.security.SecureRandom;

public class Food extends Consumable {
	SecureRandom random = new SecureRandom();
	private FoodType foodType;
	
	
    public Food(FoodType inputFoodType) {
        super();
        generateFood(inputFoodType);
    }
    
    private void generateFood(FoodType inputFoodType) {
    	if (inputFoodType == FoodType.PASTA) {
    		setFoodType(inputFoodType);
    		this.setEntityName("Pasta");
    		this.setEntityPurchaseValue(magicNumbers.PASTA_SELL_VALUE);
    		setConsumableHealValue(random.nextInt(magicNumbers.PASTA_SELL_VALUE, magicNumbers.PASTA_SELL_VALUE + magicNumbers.FOOD_VAR));
    	}
    	else {
    		setFoodType(inputFoodType);
    		this.setEntityName("Apple");
    		this.setEntityPurchaseValue(magicNumbers.APPLE_SELL_VALUE);
    		setConsumableHealValue(random.nextInt(magicNumbers.APPLE_SELL_VALUE, magicNumbers.APPLE_SELL_VALUE + magicNumbers.FOOD_VAR));
    	}
    }



	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	
	public FoodType getFoodType() {
		return foodType;
	}
}
