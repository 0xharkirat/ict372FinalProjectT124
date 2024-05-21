package com.example.ict372finalprojectt124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.BufferUnderflowException;

public class HomeActivity extends AppCompatActivity {

    Button searchButton;

    Button checkoutButton;

    Button macButton;

    Button purchaseHistoryButton;

    Button iphoneButton;

    Button msiButton;

    Button samsungButton;

    Button sonyButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        searchButton = (Button) findViewById(R.id.searchButton);
        checkoutButton = (Button) findViewById(R.id.checkoutButton);
        macButton = (Button) findViewById(R.id.macButton);
        purchaseHistoryButton = (Button) findViewById(R.id.purchaseHistoryButton);
        iphoneButton = (Button) findViewById(R.id.iphoneButton);
        samsungButton = (Button) findViewById(R.id.samsungButton);
        msiButton = (Button) findViewById(R.id.msiButton);
        sonyButton = (Button) findViewById(R.id.sonyButton);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CheckoutActivity.class);
                startActivity(intent);

            }
        });



        purchaseHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PurchaseHistoryActivity.class);
                startActivity(intent);
            }
        });


        macButton.setOnClickListener(v -> openProductDetails(new Product("Apple MacBook Air 13-inch with M3 Chip, 8-core GPU, 256GB/8GB (Midnight)[2024]", R.drawable.apple_macbook_air), "$1699"));
        iphoneButton.setOnClickListener(v -> openProductDetails(new Product("Apple iPhone 15 Pro 128GB (White Titanium)", R.drawable.apple_iphone_15_pro), "$1599"));
        samsungButton.setOnClickListener(v -> openProductDetails(new Product("Samsung Galaxy A55 5G 128GB (Awesome Navy)", R.drawable.samsung_galaxy_a55), "$599"));
        msiButton.setOnClickListener(v -> openProductDetails(new Product("MSI Modern AM272P 27\" FHD Desktop All-in-One PC (Intel i7)[2.5TB]", R.drawable.msi_modern_am272p), "$1299"));
        sonyButton.setOnClickListener(v -> openProductDetails(new Product("Sony WH-1000XM5 Premium Noise Cancelling Wireless Over-Ear Headphones (Black)", R.drawable.sony_wh_1000xm5), "$399"));




    }

    private void openProductDetails(Product product, String price) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("productName", product.getName());
        intent.putExtra("productImage", product.getImageResource());
        intent.putExtra("productPrice", price);
        startActivity(intent);
    }
}