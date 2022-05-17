package main;

import assets.enums.EntityType;
import assets.libraries.Tools;
import entities.Entity;
import entities.items.Item;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;
import exceptions.FullTeamException;

import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;

public class Inventory {
	
	Player player;
	Tools tools = new Tools();
	
	public Inventory(Player inputPlayer) {
		this.player = inputPlayer;
	}
	
	// ARRAY LIST TO HOLD MONSTERS --------------------------------
	
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	private void resetMonsters() {
		this.monsters = new ArrayList<>();
	}
	
	public void setMonsters(ArrayList<Monster> inputMonsters) {
		try {
			throw new UnallowedMethodException("Unallowed method");
		} catch (UnallowedMethodException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Monster> getMonsters() {
		return this.monsters;
	}
	
	public void addMonster(Monster inputMonster, int inputMonsterOrder) {
		try {
			if (monsters.size() >= tools.howManyMonstersBasedOnDifficulty(player.getPlayerDifficulty())) {
				throw new FullTeamException("Cannot add more monsters");
			} else {
				
			}
		}
	}
	
	public void reorderMonsters()
	
	
	
	// ARRAY LIST TO HOLD MONSTERS --------------------------------

    // ARRAY LIST TO HOLD ENTITIES --------------------------------

    /**
     * This is an ArrayList holding objects of Entity type.
     */
    private ArrayList<Entity> entities = new ArrayList<>();

    /**
     * This method resets the inventory i.e. a blank ArrayList
     */
    public void resetInventory() {
        this.entities = new ArrayList<>();
    }

    /**
     * This method, to set a custom arraylist to the arraylist entities, isn't allowed.
     * Using it will throw an error.
     * @see UnallowedMethodException
     */
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

    // ARRAY LIST TO HOLD ENTITIES --------------------------------



    // ADD AN ENTITY OBJECT INTO THE ARRAY LIST -------------------

    /**
     * All entities can be stored in an inventory but the way they should be added is different depending on
     * This method adds an entity to the arraylist above if it's a monster - regardless of they are the same or different.
     *
     * For items, we have to check first if an identical item has already existed in the inventory. If yes, update the quantity.
     * If such an item doesn't exist, then simply add that entity.
     * For example, if there are already tunas in the inventory, and the player purchases new tunas, update the quantity.
     * But if they buy lamb, then add to the arraylist.
     * @param inputEntity: Entity
     */
    public void addToInventory(Entity inputEntity) {
        if (inputEntity.getEntityType() == EntityType.ITEM) {

        } else if (inputEntity.getEntityType() == EntityType.MONSTER) {
            this.entities.add()
        }
    }

    /**
     * Food is considered already existing
     * @param inputItem
     * @return
     */
    public boolean isItemAlreadyInInventory(Item inputItem) {
        for (int index = 0; index < this.entities.size(); index++) {
            if ()
        }
    }

    // ADD AN ENTITY OBJECT INTO THE ARRAY LIST -------------------



    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------

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

    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------


    // IF AN ENTITY RUNS OUT OF ALL THE UNITS IT HAS --------------

    /**
     * This method works differently depending on the EntityType.
     * @param inputEntity
     */
    public void uponEntityUsed(Entity inputEntity) {
        if (inputEntity.)
    }
}
