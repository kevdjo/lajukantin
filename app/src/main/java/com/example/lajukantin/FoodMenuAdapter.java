package com.example.lajukantin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ViewHolder> {

    private List<FoodMenu> foodItemList;
    private LayoutInflater inflater;

    public FoodMenuAdapter(Context context, List<FoodMenu> foodItemList) {
        this.inflater = LayoutInflater.from(context);
        this.foodItemList = foodItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tenant_details_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodMenu currentFoodItem = foodItemList.get(position);

        holder.imageView.setImageResource(foodItemList.get(position).getImage());
        holder.descriptionView.setText(currentFoodItem.getDescription());
        holder.foodNameTextView.setText(currentFoodItem.getName());
        holder.priceTextView.setText("Rp." + currentFoodItem.getPrice());
        holder.quantityTextView.setText(String.valueOf(currentFoodItem.getQuantity()));

        holder.addButton.setOnClickListener(v -> {
            // Handle button click to increase quantity
            int currentQuantity = (currentFoodItem.getQuantity());
            currentQuantity++;
            currentFoodItem.setQuantity(currentQuantity);
            notifyDataSetChanged(); // Notify adapter of data change
        });

        holder.subtractButton.setOnClickListener(v -> {
            // Handle button click to decrease quantity
            int currentQuantity = (currentFoodItem.getQuantity());
            if (currentQuantity > 0) {
                currentQuantity--;
                currentFoodItem.setQuantity(currentQuantity);
                notifyDataSetChanged(); // Notify adapter of data change
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView foodNameTextView, priceTextView, quantityTextView, descriptionView;
        Button addButton, subtractButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.menuimageview);
            foodNameTextView = itemView.findViewById(R.id.foodname);
            priceTextView = itemView.findViewById(R.id.foodprice);
            descriptionView = itemView.findViewById(R.id.description);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            addButton = itemView.findViewById(R.id.addButton);
            subtractButton = itemView.findViewById(R.id.subtractButton);


        }
    }

}
