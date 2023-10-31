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
            if (item.getItem().getName().equalsIgnoreCase(itemOrdered.getItem().getName())) {
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

    public boolean changeQuantityOfProduct(ItemToOrder itemOrdered, int quantity) {
        if (itemOrdered.getItem().getQuantity() + itemOrdered.getQuantity() >= quantity) {
            itemOrdered.setQuantity(quantity);
            itemOrdered.getItem().setQuantity(quantity);
        } else {
            System.out.printf("Not enough items! Only %d %s left!%n", itemOrdered.getItem().getQuantity(), itemOrdered.getItem().getName());
            System.out.printf("Max items that you can add: %d%n", itemOrdered.getQuantity() + itemOrdered.getItem().getQuantity());
            return false;
        }

        System.out.printf("%s item quantity changed to %d %n", itemOrdered.getItem().getName(), quantity);
        return true;
    }
}
