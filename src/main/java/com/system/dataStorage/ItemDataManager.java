package com.system.dataStorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.system.itemTypes.InventoryItem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemDataManager {
    public static void loadItemsToJson(ArrayList<InventoryItem> items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/main/java/com/system/dataStorage/items.json")) {
            gson.toJson(items, writer);
            System.out.println("Json file updated!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<InventoryItem> loadItemsFromJson() {
        File file = new File("src/main/java/com/system/dataStorage/items.json");
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            if (file.exists()) {
                InventoryItem[] items = gson.fromJson(reader, InventoryItem[].class);
                System.out.println("Java objects successfully loaded from Json file!");
                return new ArrayList<>(Arrays.asList(items));
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
