package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("cart", CartServiceImpl.CART);

        return "/cart/show-cart";
    }




}
