package com.system.authentication;

import com.system.itemTypes.InventoryItem;
import com.system.orders.ItemToOrder;
import com.system.orders.Order;
import com.system.orders.ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

import static com.system.orders.ItemToOrder.chooseItem;

import static com.system.orders.ItemToOrder.hasEnoughQuantity;

public class UserImp implements User {

    private String username;
    private String password;
    private ShoppingCart cart;
    private ArrayList<Order> orders;

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

        System.out.println("Order placed!");
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

            if (chosenItem == null) {
                System.out.println("Invalid item name!");
            }
            if (chosenItem != null && !hasEnoughQuantity(chosenItem, quantity)) {
                System.out.printf("Not enough quantity! Only %d %s left!%n", chosenItem.getQuantity(), chosenItem.getName());
                System.out.println("Enter less quantity or order another product.");
                chosenItem = null;
                isValid = false;
                quantity = 0;
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

    public void changeItemQuantityByName() {
        if (this.cart.getCart().isEmpty()) {
            System.out.println("Shopping cart is empty!");
            return;
        }
        System.out.println("Your shopping cart: ");
        displayShoppingCart();
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        boolean enoughQuantity = false;
        while (!isValid || !enoughQuantity) {
            try {
                System.out.print("Enter the name of the item you want to change quantity: ");
                String itemNameToChange = sc.nextLine();
                System.out.print("Enter the new quantity: ");
                int newQuantity = Integer.parseInt(sc.nextLine());
                isValid = true;
                boolean itemFound = false;
                while (!itemFound) {
                    for (ItemToOrder item : this.cart.getCart()) {
                        if (item.getItem().getName().equalsIgnoreCase(itemNameToChange)) {
                            itemFound = true;
                            if (this.cart.changeQuantityOfProduct(item, newQuantity)) {
                                enoughQuantity = true;
                                break;
                            }
                        }
                    }
                    if (!itemFound) {
                        System.out.println("Invalid item name!");
                        isValid = false;
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid numeric option.");
            }
        }
    }


    @Override
    public void displayShoppingCart() {
        if (this.cart.getCart().isEmpty()) {
            System.out.println("Shopping cart is empty!");
            return;
        }
        for (ItemToOrder item : this.cart.getCart()) {
            System.out.printf("%d %s%n", item.getQuantity(), item.getItem().getName());
        }

    }
}
