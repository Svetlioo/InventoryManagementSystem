package com.system.itemTypes;

import java.util.UUID;

public class InventoryItem extends AbstractItem {

    protected UUID itemID;
    protected int quantity;
    protected double value;

    public InventoryItem(String name, String description, String category, double price, int quantity) {
        super(name, description, category, price);
        this.quantity = quantity;
        this.itemID = UUID.randomUUID();
        this.value = this.price * this.quantity;
    }

    @Override
    public double calculateValue() {
        return this.price * quantity;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return calculateValue();
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
