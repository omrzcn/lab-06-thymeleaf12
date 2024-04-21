package com.cydeo.service.impl;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity) {
        //todo find product based on productId
        Product product = productService.findProductById(productId);
        //todo initialise cart item using the found product
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        //todo calculate cart total amount
       BigDecimal totalAmount= cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getProduct().getRemainingQuantity()));
        //todo add to cart
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(totalAmount));
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);
        CART.setCartItemList(cartItemList);

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId) {
        //todo delete product object from cart using stream
        return true;
    }
}
