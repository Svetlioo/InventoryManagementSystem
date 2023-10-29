package com.system.itemTypes;

import com.system.interfaces.Breakable;
import com.system.interfaces.Repairable;

public class ElectronicsItem extends InventoryItem implements Breakable, Repairable {

    int brokenQuantity;

    public ElectronicsItem(String name, String description, double price, int quantity) {
        super(name, description, "Electronics", price, quantity);
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
            total += brokenQuantity * (this.price * 0.05);
            brokenQuantity = 0;
        }

        return total;
    }

    @Override
    public void repair() {
        if (hasBrokenItems()) {
            this.quantity += brokenQuantity;
            brokenQuantity = 0;
        }
    }

}
