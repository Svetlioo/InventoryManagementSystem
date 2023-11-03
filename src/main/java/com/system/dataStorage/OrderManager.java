package com.system.dataStorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.system.orders.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderManager {
    public static void loadOrdersToJson(ArrayList<Order> items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/main/java/com/system/dataStorage/orders.json")) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
