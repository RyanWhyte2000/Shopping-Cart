package com.tdd.ShoppingCart;

import com.tdd.ShoppingCart.bean.CartItem;
import com.tdd.ShoppingCart.bean.Product;
import com.tdd.ShoppingCart.implementaion.ShoppingCartImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

//Given / arrange
//When / act
//Then / assert
class ShoppingCartApplicationTests {
    Product product;
    ShoppingCartImplementation shoppingCart;
    @Before
    public void setUp(){
        product = new Product();
        shoppingCart = new ShoppingCartImplementation();
    }


    @Test
    @DisplayName("Should pass when and item is added to a cart")
    public void addItemsToCartTest() {

        Product  product = new Product();

        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();


        product.setProductId("1");
		product.setProductName("Hammer");
		product.setProductPrice("500");
        int quantity =1;
        boolean itemAddedToCart =  shoppingCart.addItemToCart(product, quantity);


        assertThat(itemAddedToCart).isTrue();
    }

    @Test
    @DisplayName("Should pass when an item is removed from a cart")
    public void removeItemsFromCartTest() {
		//arrange
        Product  product = new Product();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();

        product.setProductId("1");
        product.setProductName("Hammer");
        product.setProductPrice("500");

        boolean itemAddedToCart =  shoppingCart.removeItemFromCart(product);


        assertThat(itemAddedToCart).isTrue();
    }

    @Test
    @DisplayName("Should pass when product is added to a product list so users can select from that list ")
    public void addProductListingsTest(){
        Product  product = new Product();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();

        product = new Product();

        product.setProductId("1");
        product.setProductName("Hammer");
        product.setProductPrice("500");


        boolean newProductAdded = shoppingCart.addNewProduct(product);

        assertThat(newProductAdded).isTrue();


    }

    @Test
    @DisplayName("Should allow users to See list of Products available")
    public void viewProductListingsTest(){
        product = new Product();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();

        ArrayList<Product>   products;

        product.setProductId("1");
        product.setProductName("Hammer");
        product.setProductPrice("500");


        boolean newProductAdded = shoppingCart.addNewProduct(product);

        products = shoppingCart.viewProductList();

        assertThat(products).isNotEmpty();


    }
	@Test
    @DisplayName("Should increase the quantity of product in a cart")
    public void increaseQuantityOfProductInCartTest(){
		//arrange
		Product product = new Product();
        CartItem cart= new CartItem();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();
        int quantity =1;
		product.setProductId("1");
		product.setProductName("Hammer");
		product.setProductPrice("500");


        boolean itemAddedToCart =  shoppingCart.addItemToCart(product, quantity);

        quantity =2;
        cart.setId(1);

        shoppingCart.updateQuantityInCart( cart, quantity);


        assertThat(cart.getQuantity()).isEqualTo(2);
	}

	@Test
    @DisplayName("Should not add a product in cart if quantity is less or equal to zero")
    public void shouldNotAddProductIfQuantityLessThanZeroTest(){
        Product product = new Product();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();

        int quantity =0;
        product.setProductId("1");
        product.setProductName("Hammer");
        product.setProductPrice("500");



        boolean itemAddedToCart =  shoppingCart.addItemToCart(product, quantity);
        assertThat(itemAddedToCart).isFalse();

	}

	@Test
    @DisplayName("Should not remove a product from the cart if it is not in the cart")
	public void shouldNotRemoveProductFromCartIfNotInCartTest(){
        Product product = new Product();
        Product product2 = new Product();
        ShoppingCartImplementation shoppingCart = new ShoppingCartImplementation();

        int quantity =0;

        product.setProductId("1");
        product.setProductName("Hammer");
        product.setProductPrice("500");

        product2.setProductId("2");
        product2.setProductName("Wrench");
        product2.setProductPrice("700");

        boolean itemAddedToCart =  shoppingCart.addItemToCart(product, quantity);

        boolean checkProduct =  shoppingCart.removeItemFromCart(product2);

        assertThat(checkProduct).isFalse();


	}
//
//	@Test
//	public void  shouldNotRemoveProductFromCartIfQuantityGreaterThanOneTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
//		//cartItem.add(0,"2");
//
//
//
//		//should not happen
//		cartItem.remove(0);
//
//
//	}
//	@Test
//	public void shouldRemoveProductFromCartIfQuantityLessEqualZeroTest(){
//
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"0");
//		cartItem.remove(0);
//	}
//
//
//	@Test
//	public void updateQuantityOfProductInCartTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"0");
//		cartItem.remove(0);
//	}
//	@Test
//	public void updateQuantityOfProductInCartToZeroTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"1");
////		cartItem.set(0, "0");
//
//	}
//	@Test
//	public void ShouldNotUpdateQuantityOfProductInCartToNegativeNumberTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"1");
//
//		//should not happen
////		cartItem.set(0, "-1");
//	}
//	@Test
//	public void ShouldNotUpdateQuantityOfProductInCartToNon_integerTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"1");
//
//		//should not happen
////		cartItem.set(0, "2.5");
//	}
//	@Test
//	public void ShouldClearCartTest(){
//		ArrayList<String>  products = new ArrayList<>();
//
//		products.add(productId);
//		products.add(productName);
//		products.add(productPrice);
//
////		cartItem.add(String.valueOf(products));
//
////		cartItem.add(0,"1");
//
//		//should clear cart
//
//		cartItem.clear();
//	}
}
