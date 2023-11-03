package com.system.authentication;

import com.system.itemTypes.InventoryItem;
import com.system.orders.ItemToOrder;
import com.system.orders.Order;
import com.system.orders.ShoppingCart;

import java.util.ArrayList;

public interface User {
    String getUsername();

    String getPassword();

    void placeOrder();

    void addToShoppingCart(ArrayList<InventoryItem> items);

    void removeItemFromCartByName(String name);

    void changeItemQuantityByName();

    void displayShoppingCart();

    ArrayList<Order> getOrders();

    ShoppingCart getCart();
}
