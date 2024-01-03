package com.example.lajukantin;

public class Tenant {
    String name;
    String rating;
    String category;
    int image;

    public Tenant(String name, String rating, String category, int image) {
        this.name = name;
        this.rating = rating;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }
    public int getImage(){
        return  image;
    }
}

