package com.example.lajukantin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lajukantin.Model.CartModel;
import com.example.lajukantin.R;

import java.time.Instant;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {

    private Context ctx;
    private List<CartModel> cartModels;

    public CartAdapter(Context ctx, List<CartModel> cartModels) {
        this.ctx = ctx;
        this.cartModels = cartModels;
    }

    @NonNull
    @Override
    public CartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_cart, parent, false);
        return new CartAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewHolder holder, int position) {
        final CartModel cartModel = cartModels.get(position);
        holder.cartTitle.setText(cartModel.getTitle());
        holder.cartPrice.setText(cartModel.getPrice());
        holder.cartQuantity.setText(cartModel.getQuantity());
        holder.cartBrand.setText(cartModel.getBrand());
        Glide.with(ctx).load(cartModel.getCartImage()).into(holder.cartImage);
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView cartImage;
        private TextView cartTitle, cartBrand, cartPrice, cartQuantity;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.iv_cartImage);
            cartTitle = itemView.findViewById(R.id.txt_cartTitle);
            cartBrand = itemView.findViewById(R.id.txt_cartBrand);
            cartPrice = itemView.findViewById(R.id.txt_cartPrice);
            cartQuantity = itemView.findViewById(R.id.txt_quantity);
        }
    }
}
