package seng201.classes;

import java.util.ArrayList;

import seng201.classes.items.*;

public class Inventory {
    ArrayList<Item> items = new ArrayList<Item>();

    public void addToInventory(Item inputItem) {
        this.items.add(inputItem);
    }

    public void removeFromInventory(Item inputItem) {
        this.items.remove(inputItem);
    }

}