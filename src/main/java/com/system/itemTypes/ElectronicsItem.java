package com.system.itemTypes;

public class ElectronicsItem extends InventoryItem {
    public ElectronicsItem(String name, String description, boolean broken, boolean perished, double price, int quantity) {
        super(name, description, "Electronics item", broken, perished, price, quantity);
    }

}
