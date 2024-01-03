package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TenantDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_details);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<FoodMenu> foodItemList = new ArrayList<FoodMenu>();
        foodItemList.add(new FoodMenu("Nasi Goreng Jakarta", "Nasi yang digoreng dengan kecap manis", "15.000", R.drawable.nasgor_jkt));
        foodItemList.add(new FoodMenu("Nasi Goreng Hongkong", "Nasi yang digoreng dengan udang", "18.000", R.drawable.nasgor_hk));
        foodItemList.add(new FoodMenu("Nasi Goreng Singapura", "Nasi yang digoreng ala Singapura", "18.000", R.drawable.nasgor_sg));
        foodItemList.add(new FoodMenu("Nai Tim Ayam", "Nasi sehat dengan ayam", "15.000", R.drawable.nasitim_ayam));
        foodItemList.add(new FoodMenu("Nasi Goreng Jakarta", "Nasi yang digoreng dengan kecap manis", "15.000", R.drawable.nasgor_jkt));
        foodItemList.add(new FoodMenu("Nasi Goreng Hongkong", "Nasi yang digoreng dengan udang", "18.000", R.drawable.nasgor_hk));
        foodItemList.add(new FoodMenu("Nasi Goreng Singapura", "Nasi yang digoreng ala Singapura", "18.000", R.drawable.nasgor_sg));
        foodItemList.add(new FoodMenu("Nai Tim Ayam", "Nasi sehat dengan ayam", "15.000", R.drawable.nasitim_ayam));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FoodMenuAdapter(getApplicationContext(), foodItemList));
        bottomNavigation();
    }

    public void onBackButtonClick(View view) {
        finish();
    }


    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout resBtn = findViewById(R.id.resBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TenantDetailsActivity.this, HomeActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TenantDetailsActivity.this, ProfileActivity.class));
            }
        });
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TenantDetailsActivity.this, TenantActivity.class));
            }
        });

    }



}