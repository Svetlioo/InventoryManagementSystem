package com.system.itemTypes;

import com.system.interfaces.Breakable;
import com.system.interfaces.Perishable;

public class GroceryItem extends InventoryItem implements Perishable {
    private int calories;
    private int perishedItems;

    public GroceryItem(String name, String description, double price, int quantity, int calories) {
        super(name, description, "Grocery Item", price, quantity);
        this.calories = calories;
        this.perishedItems = 0;
    }

    @Override
    public void perishOneItem() {
        if (quantity > perishedItems) {
            perishedItems++;
        }

    }

    @Override
    public void perishAll() {
        perishedItems = quantity;
    }

    @Override
    public void handleItemExpiration() {
        this.quantity -= perishedItems;
        perishedItems = 0;
    }

    @Override
    public double sellPerishedItems() {
        double total = 0;
        total += perishedItems * (this.price * 0.03);
        perishedItems = 0;
        return total;
    }

}
