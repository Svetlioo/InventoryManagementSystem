package com.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.system.itemTypes.ElectronicsItem;
import com.system.itemTypes.GroceryItem;
import com.system.itemTypes.InventoryItem;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InventoryItem item = new ElectronicsItem("Item1", "opisanie", 2.50, 8);
        InventoryItem item2 = new ElectronicsItem("Item2", "nekvo opisanie dge", 30, 4);
        InventoryItem item3 = new GroceryItem("item3", "opisanie na nqkvo drugo", 50, 6);
        ArrayList<InventoryItem> items = loadItemsFromJson();
        addItemToList(item, items);
        addItemToList(item2, items);
        addItemToList(item3, items);
        loadItemsToJson(items);
        for (var i : items) {
            i.displayItemDetails();
        }
    }

    public static void loadItemsToJson(ArrayList<InventoryItem> items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/main/java/com/system/itemTypes/items.json")) {
            gson.toJson(items, writer);
            System.out.println("Java objects have been added to the JSON file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<InventoryItem> loadItemsFromJson() {
        File file = new File("src/main/java/com/system/itemTypes/items.json");
        Gson gson = new Gson();
        try {
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    InventoryItem[] items = gson.fromJson(reader, InventoryItem[].class);
                    return new ArrayList<>(Arrays.asList(items));
                }
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addItemToList(InventoryItem item, ArrayList<InventoryItem> items) {
        // Doing this so that I cannot add items with the same name
        for (var i : items) {
            if (i.getName().equals(item.getName())) return;
        }
        items.add(item);
    }
}

