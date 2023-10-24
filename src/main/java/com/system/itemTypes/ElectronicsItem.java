package com.system.itemTypes;

public class ElectronicsItem extends InventoryItem {
    public ElectronicsItem(String name, String description, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, "Electronics item", breakable, perishable, price, quantity);
    }

}
