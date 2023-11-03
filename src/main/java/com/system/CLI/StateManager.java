package com.system.CLI;

import com.system.authentication.Admin;
import com.system.authentication.AdminImp;
import com.system.authentication.User;
import com.system.helperMethods.Methods;
import com.system.itemTypes.InventoryItem;
import com.system.itemTypes.ItemCategory;

import java.util.ArrayList;
import java.util.Scanner;

import static com.system.authentication.Logic.*;
import static com.system.dataStorage.ItemDataManager.loadItemsFromJson;
import static com.system.dataStorage.ItemDataManager.loadItemsToJson;
import static com.system.dataStorage.OrderManager.loadOrdersToJson;
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

    public void start() {
        beforeLoginState();
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
                // Hard coded admin login :(
                if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("tainaparola")) {
                    this.currentUser = new AdminImp(username, password);
                    isLoggedIn = true;
                    System.out.printf("Successfully logged in as user %s%n", username);
                    mainStateAdmin();
                    return;
                }
                this.currentUser = loginUser(username, password);

                if (this.currentUser != null) {
                    isLoggedIn = true;
                    System.out.printf("Successfully logged in as user %s%n", username);
                    mainState();
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
        if (this.currentUser.getUsername().equalsIgnoreCase("admin") && this.currentUser.getPassword().equalsIgnoreCase("tainaparola")) {
            mainStateAdmin();
            return;
        }
        this.items = loadItemsFromJson();
        Methods.showWelcomeMessage(currentUser.getUsername());
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("+" + "-".repeat(31) + "+");
            System.out.println("| 1. Display All Items          |");
            System.out.println("| 2. Display Items by Category  |");
            System.out.println("| 3. Add to Shopping Cart       |");
            System.out.println("| 4. Remove Item by Name        |");
            System.out.println("| 5. Change Item Quantity       |");
            System.out.println("| 6. Display Shopping Cart      |");
            System.out.println("| 7. Place Order                |");
            System.out.println("| 8. Logout                     |");
            System.out.println("| 9. Exit                       |");
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
                    this.currentUser.changeItemQuantityByName();
                    break;
                case 6:
                    this.currentUser.displayShoppingCart();
                    break;
                case 7:
                    if (this.currentUser.getCart().getCart().isEmpty()) {
                        System.out.println("Shopping cart is empty!");
                        System.out.println("Add something to place a order.");
                        break;
                    }
                    this.currentUser.placeOrder();
                    loadOrdersToJson(this.currentUser.getOrders());
                    break;
                case 8:
                    this.currentUser = null;
                    beforeLoginState();
                    return;
                case 9:
                    loadItemsToJson(items);
                    System.out.println("Exiting the Inventory Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

    }

    public void mainStateAdmin() {
        this.items = loadItemsFromJson();
        Methods.showWelcomeMessage(currentUser.getUsername());
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("+" + "-".repeat(31) + "+");
            System.out.println("| 1. Display All Items          |");
            System.out.println("| 2. Display Items by Category  |");
            System.out.println("| 3. Set Price of Product       |");
            System.out.println("| 4. Set Discount Code          |");
            System.out.println("| 5. Add a new item             |");
            System.out.println("| 6. Update item quantity       |");
            System.out.println("| 7. Change Item Name           |");
            System.out.println("| 8. Break Item                 |");
            System.out.println("| 9. Handle Item Breakage       |");
            System.out.println("| 9. Handle Food Perish         |");
            System.out.println("| 10. Logout                    |");
            System.out.println("| 11. Exit                      |");
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
                case 10: {
                    this.currentUser = null;
                    beforeLoginState();
                    return;
                }
                case 11: {
                    loadItemsToJson(items);
                    System.out.println("Exiting the Inventory Management System.");
                    System.exit(0);
                }
            }
        }
    }
}
