package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

    }
}