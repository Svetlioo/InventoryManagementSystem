package com.system.itemTypes;

public class FragileItem extends  InventoryItem{
    public FragileItem(String name, String description, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, category, breakable, perishable, price, quantity);
    }
}
