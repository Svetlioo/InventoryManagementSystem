package com.system.itemTypes;

import com.system.interfaces.*;

abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
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

    @Override
    public void displayItemDetails() {
        System.out.println(String.format("""
                Name: %s
                Category: %s
                Description: %s""", this.name, this.category, this.description));
    }

    @Override
    public void displayItemDescription() {
        System.out.println(this.name + ": " + this.description);
    }




}
