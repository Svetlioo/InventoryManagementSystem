package com.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.system.interfaces.Item;
import com.system.itemTypes.ElectronicsItem;
import com.system.itemTypes.InventoryItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryItem item = new ElectronicsItem("Item1", "opisanie", false, false, 2.50, 8);
        InventoryItem item2 = new ElectronicsItem("Item2", "nekvo opisanie dge", false, false, 30, 4);
        System.out.println(item.getItemDetails());
        System.out.println(item.checkIfBreakable());
        System.out.println(item.getQuantity());

        addItemToJson(item);
        addItemToJson(item2);
    }

    public static void addItemToJson(InventoryItem item) {
        File file = new File("src/main/java/com/system/itemTypes/items.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<InventoryItem> items = new ArrayList<>();
        try {
            if (file.exists()) {
//                String jsonContent = objectMapper.writeValueAsString(objectMapper.readTree(file));
                items = objectMapper.readValue(file, new TypeReference<>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!items.contains(item)) {
            items.add(item);
        }

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(file, items);
            System.out.println("Java object has been added to the JSON file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

