package com.system.orders;

import com.system.authentication.User;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date date;
    private User owner;
    private double totalPrice;
    private ArrayList<ItemToOrder> items;

    public Order(Date date, User owner, double totalPrice, ArrayList<ItemToOrder> items) {
        this.date = date;
        this.owner = owner;
        this.totalPrice = totalPrice;
        this.items = items;
    }
}
