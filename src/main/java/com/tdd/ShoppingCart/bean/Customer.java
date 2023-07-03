package com.tdd.ShoppingCart.bean;

import lombok.Data;

@Data
public class Customer {
    public int id;
    public String firstName;
    public String lastName;

    public  String address;

    CartItem cartItem;

}
