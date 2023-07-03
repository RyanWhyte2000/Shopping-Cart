package com.tdd.ShoppingCart.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class CartItem {
    public int id;
    Product product;
    int quantity;
}
