package com.example.lajukantin;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class TenantViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, ratingView, categoryView;

    public TenantViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        ratingView = itemView.findViewById(R.id.rating);
        categoryView = itemView.findViewById(R.id.category);
    }
}

