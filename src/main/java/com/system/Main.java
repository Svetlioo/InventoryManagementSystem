package com.system;

import com.system.CLI.StateManager;
import com.system.itemTypes.ElectronicsItem;
import com.system.itemTypes.FragileItem;
import com.system.itemTypes.GroceryItem;
import com.system.itemTypes.InventoryItem;

import java.util.ArrayList;

import static com.system.dataStorage.ItemDataManager.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Test account:
                username: test
                password: 123
                """);
        StateManager state = new StateManager();
        state.beforeLoginState();
        InventoryItem item = new ElectronicsItem("Item1", "opisanieto", 2.50, 8);
        InventoryItem item2 = new FragileItem("Item2", "nqkakvo opisanie", 30, 4, 50);
        InventoryItem item3 = new GroceryItem("item3", "nqkakuv grocery item", 50, 6, 500);
        InventoryItem item4 = new GroceryItem("item4", "opisanie na drug grocery item", 60, 10, 300);
        ArrayList<InventoryItem> items = loadItemsFromJson();
        addItemToList(item, items);
        addItemToList(item2, items);
        addItemToList(item3, items);
        addItemToList(item4, items);
        for (var i : items) {
            i.displayItemDetails();
        }
//        for (var i : items) {
//            if (i.getCategory().equals("Electronics Item")) {
//                i.displayItemDetails();
//            }
//        }
        loadItemsToJson(items);
    }


}

