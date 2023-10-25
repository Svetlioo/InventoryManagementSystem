package com.system.itemTypes;

public class ElectronicsItem extends InventoryItem {
    public ElectronicsItem(String name, String description, double price, int quantity) {
        super(name, description, "Electronics item", price, quantity);
    }

}
