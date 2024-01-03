package com.example.lajukantin;

// TenantAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TenantAdapter extends RecyclerView.Adapter<TenantViewHolder> {
    Context context;
    List<Tenant> tenantList;
    RecyclerViewInterface recyclerViewInterface;

    public TenantAdapter(Context context, List<Tenant> tenantList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.tenantList = tenantList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public TenantAdapter(List<Tenant> tenantList) {
        this.tenantList = tenantList;
    }

    @NonNull
    @Override
    public TenantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TenantViewHolder(LayoutInflater.from(context).inflate(R.layout.tenant_view, parent, false), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TenantViewHolder holder, int position) {
        holder.nameView.setText(tenantList.get(position).getName());
        holder.ratingView.setText(tenantList.get(position).getRating());
        holder.categoryView.setText(tenantList.get(position).getCategory());
        holder.imageView.setImageResource(tenantList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return tenantList.size();
    }


}

