package com.system.helperMethods;

import com.system.itemTypes.InventoryItem;

import java.util.Scanner;

public class Methods {
    public static void showLoginChoices() {
        System.out.println("Press 1 for Login");
        System.out.println("Press 2 for Register");
    }

    public static void showWelcomeMessage(String username) {
        System.out.printf("Currently logged in as user %s.%n", username);
        String welcomeMessage = "Welcome to your inventory management system!";
        String border = "+" + "-".repeat(welcomeMessage.length() + 2) + "+";
        System.out.println(border);
        System.out.println("| " + welcomeMessage + " |");
        System.out.println(border);

    }

    public static void displayTestAccount() {
        System.out.println("Test account");
        System.out.println("username: test");
        System.out.println("password: 123");
        System.out.println();
    }

    public static void exitInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type \"exit\" to go back to main menu!");
        String toExit = scanner.nextLine();
        while (!toExit.equalsIgnoreCase("exit")) {
            System.out.println("Type \"exit\" to go back to main menu!");
            toExit = scanner.nextLine();
        }
    }

}
