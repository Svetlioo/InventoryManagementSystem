package com.system.interfaces;

public interface Perishable {

    void perishOneItem();

    void perishAll();

    void handleItemExpiration();

    double sellPerishedItems();
}
