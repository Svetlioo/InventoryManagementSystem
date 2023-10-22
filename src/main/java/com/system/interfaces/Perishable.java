package com.system.interfaces;

public interface Perishable {
    boolean checkIsPerishable();

    void handleItemExpiration();
}
