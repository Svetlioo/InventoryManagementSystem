package com.system.itemTypes;

import com.system.interfaces.Perishable;

public class GroceryItem extends InventoryItem {


    public GroceryItem(String name, String description, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, category, breakable, perishable, price, quantity);
    }
}
