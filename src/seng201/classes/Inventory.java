package seng201.classes;

import java.util.ArrayList;

import seng201.classes.items.*;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void addToInventory(Item inputItem) {
        this.items.add(inputItem);
    }

    public void removeFromInventory(Item inputItem) {
        this.items.remove(inputItem);
    }

    public void resetInventory() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() { return this.items; }
}