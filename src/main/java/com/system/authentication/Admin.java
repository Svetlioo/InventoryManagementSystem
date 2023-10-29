package com.system.authentication;

import com.system.itemTypes.InventoryItem;

public interface Admin extends User {

    void setPriceOfProduct(InventoryItem item, double price);

    void setDiscountCode();

    void addOneItem(InventoryItem item);

    void setItemQuantity(InventoryItem item, int quantity);

    void changeItemName(InventoryItem item, String name);

    void breakItem(InventoryItem item);

    void handleItemBreakage(InventoryItem item);

    void handleFoodPerish(InventoryItem item);
}
