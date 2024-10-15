package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    // Ver los productos del carrito
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart";
    }

    // Añadir un producto al carrito
    @PostMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + productId));
        cartService.addProductToCart(product);
        return "redirect:/cart";
    }

    // Eliminar un producto del carrito
    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") Long productId) {
        cartService.removeProductFromCart(productId);
        return "redirect:/cart";
    }
}