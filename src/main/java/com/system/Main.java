package com.system;

import com.system.CLI.StateManager;
import com.system.helperMethods.Methods;
import com.system.itemTypes.ElectronicsItem;
import com.system.itemTypes.FragileItem;
import com.system.itemTypes.GroceryItem;
import com.system.itemTypes.InventoryItem;

import java.util.ArrayList;

import static com.system.dataStorage.ItemDataManager.*;

public class Main {
    public static void main(String[] args) {
        Methods.displayTestAccount();
        StateManager state = new StateManager();
        state.start();
    }
}

