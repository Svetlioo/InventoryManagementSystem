package com.system.authentication;

import com.system.itemTypes.InventoryItem;

import java.util.ArrayList;

public interface User extends Role {
    void placeOrder(ArrayList<InventoryItem> items);
}
