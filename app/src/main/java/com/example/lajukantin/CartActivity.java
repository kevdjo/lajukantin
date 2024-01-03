package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lajukantin.Adapter.CartAdapter;
import com.example.lajukantin.Model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvMyCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        List<CartModel> cartModelList = new ArrayList<>();
        cartModelList.add(new CartModel(R.drawable.ice_tea, "Es Teh Manis", "Koffielogik", "1", "Rp 5.000"));
        cartModelList.add(new CartModel(R.drawable.nasi_goreng, "Nasi Goreng jakarta", "Nara Kitchen", "1", "Rp 15.000"));

        rvMyCart = findViewById(R.id.rv_cart);
        CartAdapter cartAdapter = new CartAdapter(this, cartModelList);
        rvMyCart.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
//        rvMyCart.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMyCart.setLayoutManager(layoutManager);
        rvMyCart.setItemAnimator(new DefaultItemAnimator());
        rvMyCart.setAdapter(cartAdapter);
    }
}