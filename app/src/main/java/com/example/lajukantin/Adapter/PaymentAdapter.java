package com.example.lajukantin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lajukantin.Interface.PaymentViewInterface;
import com.example.lajukantin.Model.PaymentModel;
import com.example.lajukantin.R;

import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.viewHolder> {

    private final PaymentViewInterface paymentViewInterface;
    private Context ctx;
    private List<PaymentModel> paymentModels;

    public PaymentAdapter(Context ctx, List<PaymentModel> paymentModels, PaymentViewInterface paymentViewInterface1) {
        this.ctx = ctx;
        this.paymentModels = paymentModels;
        this.paymentViewInterface = paymentViewInterface1;
    }

    @NonNull
    @Override
    public PaymentAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_payment, parent, false);
        return new PaymentAdapter.viewHolder(view, paymentViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdapter.viewHolder holder, int position) {
        final PaymentModel paymentModel = paymentModels.get(position);
        Glide.with(ctx).load(paymentModel.getPaymentImage()).into(holder.paymentImage);
    }

    @Override
    public int getItemCount() {
        return paymentModels.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        private ImageView paymentImage;

        public viewHolder(@NonNull View itemView, PaymentViewInterface paymentViewInterface) {
            super(itemView);
            paymentImage = itemView.findViewById(R.id.iv_paymentImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (paymentViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            paymentViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
