package com.system;

import com.system.itemTypes.ElectronicsItem;

public class Main {
    public static void main(String[] args) {
        ElectronicsItem item = new ElectronicsItem("Item1", "opisanie", false, false, 2.50, 8);
        System.out.println(item.getItemDetails());
        System.out.println(item.checkIfBreakable());
        System.out.println(item.getQuantity());
    }
}