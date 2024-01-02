package com.example.lajukantin;

public class FoodMenu {

    String name;
    String description;
    String price;
    int quantity;
    int image;

    public FoodMenu(String name, String description, String price, int image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
    public int getImage(){
        return  image;
    }

    public int getQuantity() {return quantity; }

    public void setQuantity(int currentQuantity) {
        this.quantity = quantity;
    }
}
