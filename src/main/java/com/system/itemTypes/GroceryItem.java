package com.system.itemTypes;

import com.system.interfaces.Perishable;

public class GroceryItem extends InventoryItem {
    public GroceryItem(String name, String description, double price, int quantity) {
        super(name, description, "Grocery Item", price, quantity);
    }
}
