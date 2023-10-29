package com.system.authentication;

import com.system.itemTypes.InventoryItem;
import com.system.orders.ItemToOrder;
import com.system.orders.ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

import static com.system.orders.ItemToOrder.chooseItem;

import static com.system.orders.ItemToOrder.hasEnoughQuantity;

public class UserImp implements User {

    private String username;
    private String password;
    private ShoppingCart cart;

    public UserImp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void placeOrder() {

    }

    @Override
    public void addToShoppingCart(ArrayList<InventoryItem> items) {
        Scanner sc = new Scanner(System.in);
        InventoryItem chosenItem = null;
        while (chosenItem == null) {
            System.out.println("Enter name of the item you want to buy.");
            String name = sc.nextLine();
            System.out.println("Enter quantity: ");
            int quantity = sc.nextInt();
            chosenItem = chooseItem(items, name, quantity);
            if (chosenItem != null && !hasEnoughQuantity(chosenItem, quantity)) {
                chosenItem = null;
                System.out.println("Not enough quantity! Enter less quantity or order another product.");
            }
        }
        this.cart.addItemToShoppingCart(new ItemToOrder(chosenItem, 3));
    }

    @Override
    public void removeItemFromCartByName(String name) {
        for (ItemToOrder item : cart.getCart()) {
            if (item.getItem().getName().equals(name)) {
                this.cart.removeItemFromShoppingCart(item);
            }
        }

    }

    public void changeItemQuantityByName(String name, int quantity) {
        for (ItemToOrder item : this.cart.getCart()) {
            if (item.getItem().getName().equals(name)) {
                this.cart.changeQuantityOfProduct(item, quantity);
            }
        }

    }

    @Override
    public void displayShoppingCart() {
        for (ItemToOrder item : this.cart.getCart()) {
            System.out.printf("%d %s%n", item.getQuantity(), item.getItem().getName());
        }

    }
}
