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
        this.cart = new ShoppingCart(this);
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
        int quantity = 0;
        boolean isValid = false;
        while (chosenItem == null) {
            System.out.println("Type \"exit\" to go back to main menu!");
            System.out.println("Enter name of the item you want to buy.");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) return; // Going back to main menu
            while (!isValid || quantity == 0) {
                System.out.println("Enter quantity: ");
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a valid numeric option.");
                }
            }
            chosenItem = chooseItem(items, name);
            if (chosenItem != null && !hasEnoughQuantity(chosenItem, quantity)) {
                chosenItem = null;
                System.out.println("Not enough quantity! Enter less quantity or order another product.");
            }
            if (chosenItem == null) {
                System.out.println("Invalid item name!");
            }
        }
        this.cart.addItemToShoppingCart(new ItemToOrder(chosenItem, quantity));
    }

    @Override
    public void removeItemFromCartByName(String name) {
        boolean isValid = false;
        while (!isValid) {
            for (ItemToOrder item : cart.getCart()) {
                if (item.getItem().getName().equals(name)) {
                    this.cart.removeItemFromShoppingCart(item);
                    isValid = true;
                }
            }
            if (!isValid) {
                Scanner sc = new Scanner(System.in);
                System.out.println("No such item in cart. Enter valid item name!");
                name = sc.nextLine();
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
