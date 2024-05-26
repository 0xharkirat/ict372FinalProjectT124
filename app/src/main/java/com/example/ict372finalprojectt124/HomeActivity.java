package com.example.ict372finalprojectt124;

import com.example.ict372finalprojectt124.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ProductAdapter.OnProductClickListener {


    public static final int ACTION_SEARCH = R.id.action_search;


    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    private androidx.appcompat.widget.Toolbar toolbar;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycler_view_products);
        toolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        productList = new ArrayList<>();

        // Add products
        productList.add(new Product("Apple iPhone 15 Pro 128GB (White Titanium)", 1599.99, R.drawable.apple_iphone_15_pro));
        productList.add(new Product("Apple MacBook Air 13-inch with M3 Chip, 8-core GPU, 256GB/8GB (Midnight)[2024]", 1699.99, R.drawable.apple_macbook_air));
        productList.add(new Product("MSI Modern AM272P 27\\\" FHD Desktop All-in-One PC (Intel i7)[2.5TB]", 1299.99, R.drawable.msi_modern_am272p));
        productList.add(new Product("Samsung Galaxy A55 5G 128GB (Awesome Navy)", 599.99, R.drawable.samsung_galaxy_a55));
        productList.add(new Product("Sony WH-1000XM5 Premium Noise Cancelling Wireless Over-Ear Headphones (Black)", 399.99, R.drawable.sony_wh_1000xm5));

        adapter = new ProductAdapter(productList, this);
        adapter.setOnProductClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


//

//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        checkoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, CheckoutActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//
//        purchaseHistoryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, PurchaseHistoryActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_search){
            Intent cartIntent = new Intent(this, SearchActivity.class);
            startActivity(cartIntent);
            return true;
        } else if (id == R.id.action_cart) {
            Intent cartIntent = new Intent(this, CartActivity.class);
            startActivity(cartIntent);
            return true;

        } else if (id == R.id.action_purchase_history) {
            Intent cartIntent = new Intent(this, PurchaseHistoryActivity.class);
            startActivity(cartIntent);
            return true;

        }
        else {
            return super.onOptionsItemSelected(item);

        }



    }

    @Override
    public void onProductClicked(Product product) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);


    }
}