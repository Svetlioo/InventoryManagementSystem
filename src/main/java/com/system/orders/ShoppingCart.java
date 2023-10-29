package com.system.orders;


import com.system.authentication.User;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<ItemToOrder> cart;
    private User owner;

    public ShoppingCart(User owner) {
        this.cart = new ArrayList<>();
        this.owner = owner;
    }

    public ArrayList<ItemToOrder> getCart() {
        return cart;
    }

    public void addItemToShoppingCart(ItemToOrder itemOrdered) {
        cart.add(itemOrdered);
        System.out.printf("%d %s added to shopping cart!%n", itemOrdered.getQuantity(), itemOrdered.getItem().getName());
    }

    public void removeItemFromShoppingCart(ItemToOrder itemOrdered) {
        cart.remove(itemOrdered);
        System.out.printf("%s removed from shopping cart!%n", itemOrdered.getItem().getName());
    }

    public void changeQuantityOfProduct(ItemToOrder itemOrdered, int quantity) {
        itemOrdered.setQuantity(quantity);
    }
}
