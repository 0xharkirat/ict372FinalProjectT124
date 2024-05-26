package com.example.ict372finalprojectt124;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<CartItem> cartItems = new ArrayList<>();

    public static void addToCart(Product product) {
        for (CartItem item : cartItems) {
            if (item.getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + product.getQuantity());
                return;
            }
        }
        cartItems.add(new CartItem(product.getName(), product.getPrice(), product.getImageResource(), product.getQuantity()));
    }

    public static List<CartItem> getCartItems() {
        return cartItems;
    }

    public static boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public static void removeFromCart(CartItem cartItem) {
        cartItems.remove(cartItem);
    }
}
