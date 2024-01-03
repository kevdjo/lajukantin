package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lajukantin.Adapter.CartAdapter;
import com.example.lajukantin.Adapter.UpcomingAdapter;
import com.example.lajukantin.Model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class UpcomingOrderActivity extends AppCompatActivity {

    private RecyclerView rvMyUpcoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_order);

        List<OrderModel> upcomingModelList = new ArrayList<>();
        upcomingModelList.add(new OrderModel(R.drawable.koffielogik_logo, "#254100", "Koffielogik", "2 Items", "5 Minutes"));
        upcomingModelList.add(new OrderModel(R.drawable.nara_logo, "#254100", "Nara Kitchen", "1 Items", "Ready"));

        rvMyUpcoming = findViewById(R.id.rv_upcoming);
        UpcomingAdapter upcomingAdapter = new UpcomingAdapter(this, upcomingModelList);
        rvMyUpcoming.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
//        rvMyCart.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMyUpcoming.setLayoutManager(layoutManager);
        rvMyUpcoming.setItemAnimator(new DefaultItemAnimator());
        rvMyUpcoming.setAdapter(upcomingAdapter);

        bottomNavigation();
    }
    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout resBtn = findViewById(R.id.resBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout orderBtn = findViewById(R.id.orderBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingOrderActivity.this, HomeActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingOrderActivity.this, ProfileActivity.class));
            }
        });
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingOrderActivity.this, TenantActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingOrderActivity.this, CartActivity.class));
            }
        });
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingOrderActivity.this, UpcomingOrderActivity.class));
            }
        });
    }
}