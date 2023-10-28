package com.system.authentication;

import com.system.itemTypes.InventoryItem;
import com.system.orders.ShoppingCart;

public class AdminImp extends UserImp implements Admin {

    private String username;
    private String password;
    private ShoppingCart cart;

    public AdminImp(String username, String password) {
        super(username, password);
    }

    @Override
    public void setPriceOfProduct(InventoryItem item, double price) {
        item.setPrice(price);
    }

    @Override
    public void setDiscountCode() {

    }

    @Override
    public void addOneItem(InventoryItem item) {
        item.setQuantity(item.getQuantity() + 1);
    }

    @Override
    public void setItemQuantity(InventoryItem item, int quantity) {
        item.setQuantity(quantity);
    }

    @Override
    public void changeItemName(InventoryItem item, String name) {
        item.setName(name);
    }

    @Override
    public void breakItem(InventoryItem item) {

    }

    @Override
    public void handleItemBreakage(InventoryItem item) {

    }

    @Override
    public void handleFoodPerish(InventoryItem item) {

    }
}
