package com.example.lajukantin;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodMenuHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, descriptionView, priceView, quantityTextView;
    Button addButton, subtractButton;


    public FoodMenuHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.menuimageview);
        nameView = itemView.findViewById(R.id.foodname);
        descriptionView = itemView.findViewById(R.id.description);
        priceView = itemView.findViewById(R.id.foodprice);
        quantityTextView = itemView.findViewById(R.id.quantityTextView);
        addButton = itemView.findViewById(R.id.addButton);
        subtractButton = itemView.findViewById(R.id.subtractButton);
    }
}

