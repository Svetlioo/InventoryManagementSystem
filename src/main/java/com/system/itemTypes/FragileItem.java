package com.system.itemTypes;

import com.system.interfaces.Breakable;

public class FragileItem extends InventoryItem implements Breakable {
    private double weight;
    int brokenQuantity;

    public FragileItem(String name, String description, double price, int quantity, double weight) {
        super(name, description, "Fragile", price, quantity);
        this.weight = weight;
        this.brokenQuantity = 0;
    }

    @Override
    public void breakItem() {
        if (quantity > brokenQuantity) {
            brokenQuantity++;
        }
    }

    @Override
    public void discardBrokenItems() {
        if (hasBrokenItems()) {
            this.quantity -= brokenQuantity;
            this.brokenQuantity = 0;
        }

    }

    @Override
    public boolean hasBrokenItems() {
        return this.brokenQuantity > 0;
    }

    @Override
    public double sellBrokenItems() {
        double total = 0;
        if (hasBrokenItems()) {
            total += brokenQuantity * (this.price * 0.10);
            brokenQuantity = 0;
        }

        return total;
    }

}
