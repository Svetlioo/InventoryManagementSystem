package com.system.itemTypes;

import com.system.interfaces.*;

abstract class AbstractItem implements Item, Categorizable, Sellable {
    protected String name;
    protected String description;
    protected String category;
    protected double price;

    public AbstractItem(String name, String description, String category, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

//    @Override
//    public void displayItemDetails() {
//        System.out.println(String.format("""
//                Name: %s
//                Category: %s
//                Description: %s""", this.name, this.category, this.description));
//    }
public void displayItemDetails() {
    System.out.println("+" + "-".repeat(65) + "+");
    System.out.printf("| %-63s |%n", "Name: " + this.name);
    System.out.printf("| %-63s |%n", "Category: " + this.category);
    System.out.printf("| %-63s |%n", "Description: " + this.description);
    System.out.println("+" + "-".repeat(65) + "+");
}



    @Override
    public void displayItemDescription() {
        System.out.println(this.name + ": " + this.getDescription());
    }


    public void setName(String name) {
        this.name = name;
    }
}
