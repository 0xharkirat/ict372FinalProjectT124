package com.example.ict372finalprojectt124;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {
    private EditText searchEditText;
    private RecyclerView searchRecyclerView;
    private List<Product> productList;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        searchEditText = findViewById(R.id.searchEditText);
        searchRecyclerView = findViewById(R.id.searchRecyclerView);


        // Initialize product list with dummy data (you can replace it with your actual data)
        productList = new ArrayList<>();
        productList.add(new Product("Apple iPhone 15 Pro 128GB (White Titanium)", 1599.99, R.drawable.apple_iphone_15_pro));
        productList.add(new Product("Apple MacBook Air 13-inch with M3 Chip, 8-core GPU, 256GB/8GB (Midnight)[2024]", 1699.99, R.drawable.apple_macbook_air));
        productList.add(new Product("MSI Modern AM272P 27\\\" FHD Desktop All-in-One PC (Intel i7)[2.5TB]", 1299.99, R.drawable.msi_modern_am272p));
        productList.add(new Product("Samsung Galaxy A55 5G 128GB (Awesome Navy)", 599.99, R.drawable.samsung_galaxy_a55));
        productList.add(new Product("Sony WH-1000XM5 Premium Noise Cancelling Wireless Over-Ear Headphones (Black)", 399.99, R.drawable.sony_wh_1000xm5));


        // Set up RecyclerView with custom adapter
        adapter = new CustomAdapter(productList);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchRecyclerView.setAdapter(adapter);


        // Add text change listener to searchEditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Implement search functionality here
                filter(charSequence.toString());
            }


            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void filter(String text) {
        List<Product> filteredList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.updateList(filteredList);
    }


}
