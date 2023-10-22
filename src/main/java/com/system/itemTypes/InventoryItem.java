package com.system.itemTypes;

import java.util.UUID;

public class InventoryItem extends AbstractItem {
    protected UUID itemID;
    protected int quantity;

    public InventoryItem(String name, String description, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, category, breakable, perishable, price);
        this.itemID = UUID.randomUUID();
        this.quantity = quantity;
    }


    public UUID getItemID() {
        return itemID;
    }

    public void setItemID(UUID itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
