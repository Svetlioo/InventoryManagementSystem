//package com.system;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
//import com.system.itemTypes.ElectronicsItem;
//import com.system.itemTypes.GroceryItem;
//import com.system.itemTypes.InventoryItem;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class OldMain {
//    public static void main(String[] args) {
//        InventoryItem item = new ElectronicsItem("Item1", "opisanie", 2.50, 8);
//        InventoryItem item2 = new ElectronicsItem("Item2", "nekvo opisanie dge", 30, 4);
//        InventoryItem item3 = new GroceryItem("item3", "opisanie na nqkvo drugo", 50, 6);
//        ArrayList<InventoryItem> items = loadItemsFromJson();
////        ArrayList<InventoryItem> items = new ArrayList<>();
//        items.add(item);
//        items.add(item2);
//        items.add(item3);
//        loadItemsToJson(items);
//    }
//
//    public static void loadItemsToJson(ArrayList<InventoryItem> items) {
//        File file = new File("src/main/java/com/system/itemTypes/items.json");
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
//            writer.writeValue(file, items);
//            System.out.println("Java objects have been added to the JSON file.");
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    public static ArrayList<InventoryItem> loadItemsFromJson() {
//        File file = new File("src/main/java/com/system/itemTypes/items.json");
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            if (file.exists()) {
//                return new ArrayList<>(Arrays.asList(objectMapper.readValue(file, InventoryItem[].class)));
//            } else {
//                return new ArrayList<>();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//    }
//}
//


