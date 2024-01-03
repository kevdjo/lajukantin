package com.example.lajukantin.Model;

public class CartModel {
    private int cartImage;
    private String title;
    private String brand;
    private String quantity;
    private String price;

    public CartModel(int cartImage, String title, String brand, String quantity, String price) {
        this.cartImage = cartImage;
        this.title = title;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
    }

    public int getCartImage() {
        return cartImage;
    }

    public void setCartImage(int cartImage) {
        this.cartImage = cartImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
