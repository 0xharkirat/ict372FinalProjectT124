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

        holder.subtractButton.setOnClickListener(v -> {
            int position1 = holder.getAdapterPosition();
            if (position1 != RecyclerView.NO_POSITION) {
                CartItem cartItem1 = cartItemList.get(position1);
                int quantity = cartItem1.getQuantity();
                if (quantity > 1) {
                    quantity--;
                    cartItem1.setQuantity(quantity);
                    holder.quantityText.setText(String.valueOf(quantity));
                    holder.productPriceTextView.setText(String.valueOf(cartItem1.getPrice() * quantity));
                }
            }
        });

        holder.addButton.setOnClickListener(v -> {
            int position1 = holder.getAdapterPosition();
            if (position1 != RecyclerView.NO_POSITION) {
                CartItem cartItem1 = cartItemList.get(position1);
                int quantity = cartItem1.getQuantity();
                quantity++;
                cartItem1.setQuantity(quantity);
                holder.quantityText.setText(String.valueOf(quantity));
                holder.productPriceTextView.setText(String.valueOf(cartItem1.getPrice() * quantity));
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            int position1 = holder.getAdapterPosition();
            if (position1 != RecyclerView.NO_POSITION) {
                CartItem cartItem1 = cartItemList.get(position1);
                cartItemList.remove(position1);
                Cart.removeFromCart(cartItem1);
                notifyItemRemoved(position1);
                notifyItemRangeChanged(position1, cartItemList.size());

                // Notify the activity to update the UI
                if (context instanceof CartActivity) {
                    ((CartActivity) context).updateUI();
                }
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

