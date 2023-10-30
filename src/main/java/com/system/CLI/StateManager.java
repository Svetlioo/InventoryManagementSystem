package com.system.CLI;

import com.system.authentication.User;
import com.system.helperMethods.Methods;
import com.system.itemTypes.InventoryItem;
import com.system.itemTypes.ItemCategory;

import java.util.ArrayList;
import java.util.Scanner;

import static com.system.authentication.Logic.*;
import static com.system.dataStorage.ItemDataManager.loadItemsFromJson;
import static com.system.helperMethods.Methods.exitInput;
import static com.system.helperMethods.Methods.showLoginChoices;

public class StateManager {

    private final ArrayList<User> users;
    private User currentUser;
    private ArrayList<InventoryItem> items;

    public StateManager() {
        this.users = new ArrayList<>();
        this.currentUser = null;
        this.items = new ArrayList<>();
    }

    public void beforeLoginState() {
        Scanner sc = new Scanner(System.in);
        loadUserProfiles();
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            showLoginChoices();
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                this.currentUser = loginUser(username, password);
                if (this.currentUser != null) {
                    isLoggedIn = true;
                    System.out.printf("Successfully logged in as user %s%n", username);
                } else {
                    System.out.println("Incorrect username or password. Try again!");
                }
            } else if (input.equals("2")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                String successfulRegistry = registerUser(username, password);
                if (successfulRegistry.equals("Registered successfully")) {
                    System.out.printf("User %s registered successfully. Login to book a room!%n", username);
                }
                if (successfulRegistry.equals("Already registered")) {
                    System.out.printf("User %s is already registered. Login to book a room!%n", username);
                }
                if (successfulRegistry.equals("Username already in use")) {
                    System.out.printf("Username %s is already in use. Use different username!%n", username);
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public void mainState() {
        this.items = loadItemsFromJson();
        Methods.showWelcomeMessage(currentUser.getUsername());
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 8) {
            System.out.println("+" + "-".repeat(31) + "+");
            System.out.println("| 1. Display All Items          |");
            System.out.println("| 2. Display Items by Category  |");
            System.out.println("| 3. Add to Shopping Cart       |");
            System.out.println("| 4. Remove Item by Name        |");
            System.out.println("| 5. Change Item Quantity       |");
            System.out.println("| 6. Display Shopping Cart      |");
            System.out.println("| 7. Place Order                |");
            System.out.println("| 8. Exit                       |");
            System.out.println("+" + "-".repeat(31) + "+");
            System.out.print("Enter your choice: ");
            boolean valid = false;
            while (!valid) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a valid numeric option.");
                }
            }

            switch (choice) {
                case 1:
                    for (var i : this.items) {
                        i.displayItemDetails();
                    }

                    exitInput();
                    break;
                case 2:
                    ItemCategory selectedCategory = null;
                    boolean validInput = false;
                    System.out.println("Select a category:");
                    ItemCategory[] categories = ItemCategory.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + " - " + categories[i]);
                    }

                    while (!validInput) {
                        String userInput = scanner.nextLine();
                        try {
                            int input = Integer.parseInt(userInput);
                            if (input >= 1 && input <= categories.length) {
                                selectedCategory = categories[input - 1];
                                validInput = true;
                            } else {
                                System.out.println("Invalid choice. Please enter a valid numeric option.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid choice. Please enter a valid numeric option.");
                        }
                    }

                    System.out.println("You selected: " + selectedCategory.name());
                    for (var i : this.items) {
                        if (i.getCategory().equalsIgnoreCase(selectedCategory.name())) {
                            i.displayItemDetails();
                        }
                    }

                    exitInput();
                    break;
                case 3:
                    this.currentUser.addToShoppingCart(this.items);
                    break;
                case 4:
                    System.out.print("Enter the name of the item to remove: ");
                    String itemName = scanner.nextLine();
                    this.currentUser.removeItemFromCartByName(itemName);
                    break;
                case 5:
                    System.out.print("Enter the name of the item you want to remove: ");
                    String itemNameToChange = scanner.nextLine();
                    System.out.print("Enter the new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    this.currentUser.changeItemQuantityByName(itemNameToChange, newQuantity);
                    break;
                case 6:
                    this.currentUser.displayShoppingCart();
                    break;
                case 7:
                    this.currentUser.placeOrder();
                    break;
                case 8:
                    System.out.println("Exiting the Inventory Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
