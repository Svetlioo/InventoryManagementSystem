package com.system.itemTypes;

public class FragileItem extends InventoryItem {
    public FragileItem(String name, String description, double price, int quantity) {
        super(name, description, "Fragile Item", price, quantity);
    }
}
