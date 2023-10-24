package com.system.itemTypes;

import com.system.interfaces.Perishable;

public class GroceryItem extends InventoryItem {
    public GroceryItem(String name, String description, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, "Grocery Item", breakable, perishable, price, quantity);
    }
}
