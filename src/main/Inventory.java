package main;

import assets.libraries.Tools;
import entities.items.Item;
import entities.monsters.Monster;
import exceptions.FullTeamException;
import exceptions.UnallowedMethodException;

import java.util.ArrayList;

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

    public void addMonster(Monster inputMonster) {
        try {
            if (monsters.size() >= tools.howManyMonstersBasedOnDifficulty(player.getPlayerDifficulty())) {
                throw new FullTeamException("Cannot add more monsters");
            } else {
                getMonsters().add(inputMonster);
            }
        } catch (FullTeamException e) {
            e.printStackTrace();
        }
    }

    public void reorderMonsters() {
        System.out.println("Implement me");
    }


    // ARRAY LIST TO HOLD MONSTERS --------------------------------

    // ARRAY LIST TO HOLD ITEMS --------------------------------

    /**
     * This is an ArrayList holding objects of Entity type.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * This method resets the inventory i.e. a blank ArrayList
     */
    public void resetItems() {
        this.items = new ArrayList<>();
    }

    /**
     * This method, to set a custom arraylist to the arraylist entities, isn't allowed.
     * Using it will throw an error.
     *
     * @see UnallowedMethodException
     */
    public void setItems() {
        try {
            throw new UnallowedMethodException("Unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the ArrayList entities
     *
     * @return this.entities: ArrayList
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addToItems(Item inputItem) {
        this.items.add(inputItem);
    }
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


    // ADD AN ENTITY OBJECT INTO THE ARRAY LIST -------------------



    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------


    // REMOVE AN ENTITY OBJECT FROM THE ARRAY LIST ----------------


    // IF AN ENTITY RUNS OUT OF ALL THE UNITS IT HAS --------------


