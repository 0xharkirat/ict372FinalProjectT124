package com.example.ict372finalprojectt124;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int imageResource;
    private double price;
    private int quantity; // Add quantity attribute






    public Product(String name, double price, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.quantity = 1; //
    }


    public String getName() {
        return name;
    }


    public int getImageResource() {
        return imageResource;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
