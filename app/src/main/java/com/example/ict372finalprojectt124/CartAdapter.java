package com.example.ict372finalprojectt124;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItemList;
    private Context context;

    public CartAdapter(List<CartItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product cartItem = cartItemList.get(position);

        holder.productImageView.setImageResource(cartItem.getImageResource());
        holder.productNameTextView.setText(cartItem.getName());
        holder.productPriceTextView.setText(String.valueOf(cartItem.getPrice() * cartItem.getQuantity()));
        holder.quantityText.setText(String.valueOf(cartItem.getQuantity()));


        holder.subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Product cartItem = cartItemList.get(position);
                    int quantity = cartItem.getQuantity();
                    // Ensure quantity is greater than 1
                    if (quantity > 1) {
                        quantity--; // Decrease quantity by 1
                        cartItem.setQuantity(quantity);
                        // Update quantity display
                        holder.quantityText.setText(String.valueOf(quantity));
                        // Update price based on quantity
                        holder.productPriceTextView.setText(String.valueOf(cartItem.getPrice() * quantity));
                    }
                }
            }
        });

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Product cartItem = cartItemList.get(position);
                    int quantity = cartItem.getQuantity();
                    quantity++; // Increase quantity by 1
                    cartItem.setQuantity(quantity);
                    // Update quantity display
                    holder.quantityText.setText(String.valueOf(quantity));
                    // Update price based on quantity
                    holder.productPriceTextView.setText(String.valueOf(cartItem.getPrice() * quantity));
                }
            }
        });


        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
                // For example, remove the item from the list and notify adapter
                cartItemList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImageView;
        public TextView productNameTextView;
        public TextView productPriceTextView;
        public Button subtractButton;
        public Button addButton;
        public TextView quantityText;
        public Button deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.item_product_image);
            productNameTextView = itemView.findViewById(R.id.item_product_name);
            productPriceTextView = itemView.findViewById(R.id.item_product_price);
            subtractButton = itemView.findViewById(R.id.subtract_button);
            addButton = itemView.findViewById(R.id.add_button);
            quantityText = itemView.findViewById(R.id.quantity_text);
            deleteButton = itemView.findViewById(R.id.delete_button);


        }
    }
}
