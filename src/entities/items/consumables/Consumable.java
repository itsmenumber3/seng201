package entities.items.consumables;

import assets.enums.ConsumableType;
import assets.enums.ItemType;
import entities.items.Item;

/**
 * The interface Consumable provides for a blueprint to implement the classes food and potion.
 * @see Food
 * @see Drink
 */
public class Consumable extends Item {
	
	private double consumableHealValue;
	
	/** Constructor method
	 * 
	 */
    public Consumable() {
        super();
    }

    // CONSUMABLE TYPE ------------------------------------------------------------

    /**
     * ConsumableType (enum) can be either Food or Potion
     * @see ConsumableType
     */
    public ConsumableType consumableType;

    /**
     * This method sets the consumable type
     * @param inputConsumableType ConsumableType
     * @see ConsumableType
     */
    public void setConsumableType(ConsumableType inputConsumableType) {
        this.consumableType = inputConsumableType;
    }

    /**
     * This method returns the consumable type
     * @return consumableType of enum type ConsumableType
     */
    public ConsumableType getConsumableType() {
        return this.consumableType;
    }

    // CONSUMABLE TYPE ------------------------------------------------------------


    // HEAL VALUE -----------------------------------------------------------------
    
    
    public void setConsumableHealValue(int inputConsumableHealValue) {
    	this.consumableHealValue = inputConsumableHealValue;
    }
    
    public double getConsumableHealValue() {
    	return this.consumableHealValue;
    }


    // HEAL VALUE -----------------------------------------------------------------
}
