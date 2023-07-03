package com.tdd.ShoppingCart.implementaion;

import com.tdd.ShoppingCart.ShoppingCart;
import com.tdd.ShoppingCart.bean.CartItem;
import com.tdd.ShoppingCart.bean.Product;

import java.util.ArrayList;

public class ShoppingCartImplementation implements ShoppingCart {
    CartItem cart= new CartItem();
    ArrayList<Product> productList = new ArrayList<>();

    ArrayList<CartItem> cartItemArrayList = new ArrayList<>();
    @Override
    public boolean addItemToCart(Product product,  int quantity) {

        boolean itemAdded = false;

        if(quantity <= 0)
            return  itemAdded;

        cart.setId(1);
        cart.setProduct(product);
        cart.setQuantity(quantity);

        cartItemArrayList.add(cart);
        itemAdded =true;

    return itemAdded;
    }

    public  boolean removeItemFromCart(Product product){
        boolean itemRemoved = false;

        if(cart.getProduct().getProductId() == product.getProductId()){
            cart.setQuantity(0);

            if(cart.getQuantity() == 0){
                cartItemArrayList.remove(0);
            }
            itemRemoved = true;

        }

        return itemRemoved;

   }

    @Override
    public boolean addNewProduct(Product product) {
        boolean newProductAdded =false;

        productList.add(product);
        newProductAdded = true;

        return newProductAdded;
    }

    public ArrayList<Product>   viewProductList() {
               return  productList;
    }

    @Override
    public void updateQuantityInCart(CartItem cart, int quantity) {
        cartItemArrayList.get(cart.id).setQuantity(quantity);
    }
}
