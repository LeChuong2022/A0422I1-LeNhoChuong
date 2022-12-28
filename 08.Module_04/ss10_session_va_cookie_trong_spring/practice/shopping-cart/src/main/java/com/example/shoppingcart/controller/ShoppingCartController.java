package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {
    @Autowired
    HttpSession httpSession;

    @GetMapping("shopping-cart")
    public String showCart(Model model, @ModelAttribute("cart")Cart cart){
        if (httpSession.getAttribute("cart") != null){
            cart = (Cart) httpSession.getAttribute("cart");
        }
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
