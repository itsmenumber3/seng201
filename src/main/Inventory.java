package main;

import java.util.ArrayList;

import entities.*;
import exceptions.UnallowedMethodException;

public class Inventory {
    private ArrayList<Entity> entities = new ArrayList<>();

    /**
     * This method adds an Entity into the entities ArrayList
     * @param inputEntity: Entity
     */
    public void addToInventory(Entity inputEntity) {
        this.entities.add(inputEntity);
    }

    /**
     * This method removes an entity from the ArrayList entities
     * And then return it
     * @param inputEntity: Entity
     * @return inputEntity: Entity
     */
    public Entity removeFromInventory(Entity inputEntity) {
        this.entities.remove(inputEntity);
        return inputEntity;
    }

    /**
     * This method resets the inventory i.e. a blank ArrayList
     */
    public void resetInventory() {
        this.entities = new ArrayList<>();
    }
    
    public void setInventory() {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the ArrayList entities
     * @return this.entities: ArrayList
     */
    public ArrayList<Entity> getItems() { 
        return this.entities; 
    }
}
