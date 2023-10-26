package com.system.itemTypes;

import com.system.interfaces.Breakable;
import com.system.interfaces.Perishable;

public class ElectronicsItem extends InventoryItem implements Breakable {
    public ElectronicsItem(String name, String description, double price, int quantity) {
        super(name, description, "Electronics Item", price, quantity);
    }

    @Override
    public boolean checkIfBreakable() {
        return false;
    }

    @Override
    public void handleItemBreakage() {

    }
}
