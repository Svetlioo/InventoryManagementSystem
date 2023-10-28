package com.system.authentication;

import com.system.itemTypes.InventoryItem;
import com.system.orders.ItemToOrder;

import java.util.ArrayList;

public interface User extends Role {
    void placeOrder(ArrayList<InventoryItem> items);

    void addToShoppingCart(ItemToOrder item);

    void removeItemFromCartByName(String name);
}
