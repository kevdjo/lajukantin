package com.example.lajukantin.Model;

public class OrderModel {

    private int orderImage;
    private String orderID;
    private String brand;
    private String quantity;
    private String duration;

    public OrderModel(int orderImage, String orderID, String brand, String quantity, String duration) {
        this.orderImage = orderImage;
        this.orderID = orderID;
        this.brand = brand;
        this.quantity = quantity;
        this.duration = duration;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
