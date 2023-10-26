package com.system.itemTypes;

import com.system.interfaces.Breakable;
import com.system.interfaces.Perishable;

public class GroceryItem extends InventoryItem implements Perishable {
    private int calories;
    public GroceryItem(String name, String description, double price, int quantity, int calories) {
        super(name, description, "Grocery Item", price, quantity);
        this.calories = calories;
    }

    @Override
    public boolean checkIsPerishable() {
        return false;
    }

    @Override
    public void handleItemExpiration() {

    }
}
