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

public class HomeActivity extends AppCompatActivity {

    Button searchButton;

    Button checkoutButton;

    Button macButton;

    Button purchaseHistoryButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        searchButton = (Button) findViewById(R.id.searchButton);
        checkoutButton = (Button) findViewById(R.id.checkoutButton);
        macButton = (Button) findViewById(R.id.macButton);
        purchaseHistoryButton = (Button) findViewById(R.id.purchaseHistoryButton);



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

        macButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
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




    }
}