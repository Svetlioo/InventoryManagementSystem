package com.system.itemTypes;

import com.system.interfaces.Breakable;

public class FragileItem extends InventoryItem implements Breakable {
    private double weight;

    public FragileItem(String name, String description, double price, int quantity, double weight) {
        super(name, description, "Fragile Item", price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean checkIfBreakable() {
        return false;
    }

    @Override
    public void handleItemBreakage() {

    }
}
