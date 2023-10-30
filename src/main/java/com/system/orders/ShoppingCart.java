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
        boolean itemAlreadyAdded = false;
        for (ItemToOrder item : this.cart) {
            if (item.getItem().getName().equals(itemOrdered.getItem().getName())) {
                item.setQuantity(item.getQuantity() + itemOrdered.getQuantity());
                itemAlreadyAdded = true;
            }
        }
        if (!itemAlreadyAdded) {
            cart.add(itemOrdered);
        }
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
