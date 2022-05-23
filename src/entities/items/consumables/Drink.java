package entities.items.consumables;

import assets.enums.DrinkType;
import java.security.SecureRandom;

public class Drink extends Consumable {
	SecureRandom random = new SecureRandom();
	private DrinkType drinkType;
	
	
    public Drink(DrinkType inputDrinkType) {
        super();
        generateDrink(inputDrinkType);
    }
    
    private void generateDrink(DrinkType inputDrinkType) {
    	if (inputDrinkType == DrinkType.COFFEE) {
    		setDrinkType(inputDrinkType);
    		this.setEntityName("Coffee");
    		this.setEntityPurchaseValue(magicNumbers.COFFEE_SELL_VALUE);
    		setConsumableHealValue(10);
    		
    	}
    	else {
    		setDrinkType(inputDrinkType);
    		this.setEntityName("Energy Drink");
    		this.setEntityPurchaseValue(magicNumbers.ENERGY_DRINK_SELL_VALUE);
    		setConsumableHealValue(15);
    	}
    }


	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}
}
