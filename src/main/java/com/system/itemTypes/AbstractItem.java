package com.system.itemTypes;

import com.system.interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    protected String name;
    protected String description;
    protected String category;
    protected boolean breakable;
    protected boolean perishable;


    public AbstractItem(String name, String description, String category, boolean breakable, boolean perishable, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
    }

    protected double price;

    @Override
    public boolean checkIfBreakable() {
        return this.breakable;
    }

    @Override
    public void handleItemBreakage() {

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
    public String getItemDetails() {
        return String.format("""
                Name: %s
                Category: %s
                Description: %s""", this.name, this.category, this.description);
    }

    @Override
    public double calculateValue() {
        return this.price;
    }

    @Override
    public String displayItemDescription() {
        return this.description;
    }

    @Override
    public boolean checkIsPerishable() {
        return this.perishable;
    }

    @Override
    public void handleItemExpiration() {

    }

    @Override
    public double getItemPrice() {
        return this.price;
    }

    @Override
    public void setItemPrice(double price) {
        this.price = price;
    }
}
