package main;

import java.util.ArrayList;

import items.*;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public void addToInventory(Item inputItem) {
        this.items.add(inputItem);
    }

    public void removeFromInventory(Item inputItem) {
        this.items.remove(inputItem);
    }

    public void resetInventory() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() { return this.items; }
}
