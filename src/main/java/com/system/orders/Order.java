package com.system.orders;

import com.system.authentication.User;

import java.util.Date;

public class Order {
    Date date;
    User owner;
    double totalPrice;

    public Order(Date date, User owner, double totalPrice) {
        this.date = date;
        this.owner = owner;
        this.totalPrice = totalPrice;
    }
}
