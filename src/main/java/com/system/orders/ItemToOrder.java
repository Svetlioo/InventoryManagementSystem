package com.system.orders;

import com.system.itemTypes.InventoryItem;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemToOrder {

    private InventoryItem item;
    private int quantity;

    public static InventoryItem chooseItem(ArrayList<InventoryItem> items, String name) {

        for (InventoryItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public ItemToOrder(InventoryItem item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
        this.item = item;
        this.quantity = quantity;
    }

    public InventoryItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.item.setQuantity(this.item.getQuantity() + this.quantity - quantity);
        this.quantity = quantity;
    }

    public static boolean hasEnoughQuantity(InventoryItem item, int quantity) {
        return item.getQuantity() >= quantity;
    }
}
