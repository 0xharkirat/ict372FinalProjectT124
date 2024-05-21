package com.example.ict372finalprojectt124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    private ImageView productImageView;
    private TextView productNameTextView, productPriceTextView;
    private EditText quantityEditText;
    private Button addToCartButton, incrementButton, decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        productImageView = findViewById(R.id.imageView);
        productNameTextView = findViewById(R.id.productTitle);
        productPriceTextView = findViewById(R.id.productPrice);
        quantityEditText = findViewById(R.id.quantityText);
        addToCartButton = findViewById(R.id.cartButton);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);

        Intent intent = getIntent();
        String productName = intent.getStringExtra("productName");
        int productImage = intent.getIntExtra("productImage", -1);
        String productPrice = intent.getStringExtra("productPrice");

        if (productImage != -1) {
            productImageView.setImageResource(productImage);
        }
        productNameTextView.setText(productName);
        productPriceTextView.setText(productPrice);

        incrementButton.setOnClickListener(v -> {
            int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
            quantityEditText.setText(String.valueOf(quantity + 1));
        });

        decrementButton.setOnClickListener(v -> {
            int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
            if (quantity > 1) {
                quantityEditText.setText(String.valueOf(quantity - 1));
            }
        });






    }
}