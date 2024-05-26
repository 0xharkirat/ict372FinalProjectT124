package com.example.ict372finalprojectt124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter adapter;

    private TextView textEmptyCart;
    private Button buttonProceedToCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recycler_view_cart);
        textEmptyCart = findViewById(R.id.text_empty_cart);
        buttonProceedToCheckout = findViewById(R.id.button_proceed_to_checkout);



        // Load cart items
        List<CartItem> cartItems = Cart.getCartItems();

        // Set up RecyclerView
        adapter = new CartAdapter(cartItems, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Update UI based on cart items
        if (cartItems.isEmpty()) {
            textEmptyCart.setVisibility(View.VISIBLE);
            buttonProceedToCheckout.setVisibility(View.GONE);
        } else {
            textEmptyCart.setVisibility(View.GONE);
            buttonProceedToCheckout.setVisibility(View.VISIBLE);
        }

        buttonProceedToCheckout.setOnClickListener(v -> {
            startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
        });

    }
}