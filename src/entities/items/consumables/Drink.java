package entities.items.consumables;

import assets.enums.DrinkType;
import java.security.SecureRandom;

public class Drink extends Consumable {
	SecureRandom random = new SecureRandom();
	private int healthIncrease;
	private DrinkType drinkType;
	
	
    public Drink(DrinkType inputDrinkType) {
        super();
        generateDrink(inputDrinkType);
    }
    
    private void generateDrink(DrinkType inputDrinkType) {
    	if (inputDrinkType == DrinkType.COFFEE) {
    		setDrinkType(inputDrinkType);
    		super.setEntityName("Coffee");
    		super.setEntityPurchaseValue(magicNumbers.COFFEE_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.COFFEE_SELL_VALUE, magicNumbers.COFFEE_SELL_VALUE + magicNumbers.DRINK_VAR));
    		
    	}
    	else {
    		setDrinkType(inputDrinkType);
    		super.setEntityName("Energy Drink");
    		super.setEntityPurchaseValue(magicNumbers.ENERGY_DRINK_SELL_VALUE);
    		setHealthIncrease(random.nextInt(magicNumbers.ENERGY_DRINK_SELL_VALUE, magicNumbers.ENERGY_DRINK_SELL_VALUE + magicNumbers.DRINK_VAR));
    	}
    }

	public int getHealthIncrease() {
		return healthIncrease;
	}


	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}
}
