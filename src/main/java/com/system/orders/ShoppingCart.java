package com.system.orders;

import com.system.itemTypes.InventoryItem;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemToOrder> cart = new ArrayList<>();

    public void addItemToShoppingCart(ItemToOrder itemOrdered) {
        cart.add(itemOrdered);
        System.out.printf("%d %s added to shopping cart!%n", itemOrdered.getQuantity(), itemOrdered.getItem().getName());
    }
}
