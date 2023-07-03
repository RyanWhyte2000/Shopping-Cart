package com.tdd.ShoppingCart;

import com.tdd.ShoppingCart.bean.CartItem;
import com.tdd.ShoppingCart.bean.Product;

import java.util.ArrayList;

public interface ShoppingCart {
    public boolean addItemToCart(Product product, int quantity);

    public  boolean removeItemFromCart(Product product);


    boolean addNewProduct(Product product);
    public ArrayList<Product> viewProductList();

    void updateQuantityInCart(CartItem cart, int quantity);
}
