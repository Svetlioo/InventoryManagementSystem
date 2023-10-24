package com.system.itemTypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class InventoryItem extends AbstractItem {
    protected UUID itemID;
    protected int quantity;
    protected double value;

    public InventoryItem(String name, String description, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, description, category, breakable, perishable, price);
        this.quantity = quantity;
        this.itemID = UUID.randomUUID();
    }

    public InventoryItem(String name, String description, String category, boolean breakable, boolean perishable, double price, UUID itemID, int quantity, double value) {
        super(name, description, category, breakable, perishable, price);
        this.itemID = itemID;
        this.quantity = quantity;
        this.value = value;
    }

    @Override
    public double calculateValue() {
        return this.price * quantity;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void handleItemBreakage() {

    }

    @Override
    public void handleItemExpiration() {

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
