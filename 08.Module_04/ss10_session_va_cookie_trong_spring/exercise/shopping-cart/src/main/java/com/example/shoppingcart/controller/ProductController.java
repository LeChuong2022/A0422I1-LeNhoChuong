package com.example.shoppingcart.controller;


import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.findById(id).get());
        return "/detail";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        // để lấy lại session
        if (httpSession.getAttribute("cart") != null) {
            cart = (Cart) httpSession.getAttribute("cart");
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            httpSession.setAttribute("cart", cart);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        httpSession.setAttribute("cart", cart);
        return "redirect:/shop";
    }
   @GetMapping("remove/{id}")
    public String removeOutCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        // để lấy lại session
        if (httpSession.getAttribute("cart") != null) {
            cart = (Cart) httpSession.getAttribute("cart");
        }
        if (action.equals("show")) {
            cart.removeAmountProduct(productOptional.get());
            httpSession.setAttribute("cart", cart);
            return "redirect:/shopping-cart";
        }
        cart.removeAmountProduct(productOptional.get());
        httpSession.setAttribute("cart", cart);
        return "redirect:/shop";
    }
}
