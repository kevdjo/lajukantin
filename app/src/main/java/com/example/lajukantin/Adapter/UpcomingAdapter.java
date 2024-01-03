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
import com.example.lajukantin.Model.OrderModel;
import com.example.lajukantin.R;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.viewHolder>{
    private Context ctx;
    private List<OrderModel> upcomingModels;

    public UpcomingAdapter(Context ctx, List<OrderModel> upcomingModel) {
        this.ctx = ctx;
        this.upcomingModels = upcomingModel;
    }

    @NonNull
    @Override
    public UpcomingAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.upcoming_item_order, parent, false);
        return new UpcomingAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel orderModel = upcomingModels.get(position);
        holder.orderID.setText(orderModel.getOrderID());
        holder.orderBrand.setText(orderModel.getBrand());
        holder.orderQuantity.setText(orderModel.getQuantity());
        holder.orderDuration.setText(orderModel.getDuration());
        Glide.with(ctx).load(orderModel.getOrderImage()).into(holder.orderImage);
    }



    @Override
    public int getItemCount() {
        return upcomingModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView orderImage;
        private TextView orderID, orderBrand, orderQuantity, orderDuration;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.iv_orderImage);
            orderID = itemView.findViewById(R.id.txt_orderID);
            orderBrand = itemView.findViewById(R.id.txt_orderBrand);
            orderQuantity = itemView.findViewById(R.id.txt_orderQuantity);
            orderDuration = itemView.findViewById(R.id.txt_orderDuration);
        }
    }
}
