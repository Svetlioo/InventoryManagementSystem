package com.system.helperMethods;

import com.system.itemTypes.InventoryItem;

public class Methods {
    public static void showLoginChoices() {
        System.out.println("""
                Press 1 for Login
                Press 2 for Register""");
    }

    public static void showWelcomeMessage(String username) {
        System.out.printf("Currently logged in as user %s.%n", username);
        String welcomeMessage = "Welcome to your inventory management system!";
        String border = "+" + "-".repeat(welcomeMessage.length() + 2) + "+";
        System.out.println(border);
        System.out.println("| " + welcomeMessage + " |");
        System.out.println(border);

    }

}
