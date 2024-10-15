package com.example.demo.services;

import com.example.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<Product> cartItems = new ArrayList<>();

    // Obtener todos los productos del carrito
    public List<Product> getCartItems() {
        return cartItems;
    }

    // Añadir producto al carrito
    public void addProductToCart(Product product) {
        cartItems.add(product);
    }

    // Eliminar producto del carrito
    public void removeProductFromCart(Long productId) {
        cartItems.removeIf(product -> product.getId().equals(productId));
    }

    // Vaciar el carrito (opcional)
    public void clearCart() {
        cartItems.clear();
    }
}