package com.system.CLI;

import com.system.authentication.Role;

import java.util.ArrayList;
import java.util.Scanner;

import static com.system.authentication.Logic.*;
import static com.system.helperMethods.Methods.showLoginChoices;

public class StateManager {
    private ArrayList<Role> users = new ArrayList<>();
    private Role currentUser;
    public StateManager() {
        this.users = new ArrayList<>();
        this.currentUser = null;
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
}
