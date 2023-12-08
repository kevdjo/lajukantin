package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Tenant> tenantList = new ArrayList<Tenant>();
        tenantList.add(new Tenant("Nara Kitchen", "4.7", "Rice", R.drawable.nara));
        tenantList.add(new Tenant("Rocky Rooster", "4.5", "Chicken", R.drawable.rocky));
        tenantList.add(new Tenant("Good Waffle", "4.7", "Snacks", R.drawable.waffle));
        tenantList.add(new Tenant("Nara Kitchen", "4.7", "Rice", R.drawable.nara));
        tenantList.add(new Tenant("Rocky Rooster", "4.5", "Chicken", R.drawable.rocky));
        tenantList.add(new Tenant("Good Waffle", "4.7", "Snacks", R.drawable.waffle));
        tenantList.add(new Tenant("Nara Kitchen", "4.7", "Rice", R.drawable.nara));
        tenantList.add(new Tenant("Rocky Rooster", "4.5", "Chicken", R.drawable.rocky));
        tenantList.add(new Tenant("Good Waffle", "4.7", "Snacks", R.drawable.waffle));
        tenantList.add(new Tenant("Nara Kitchen", "4.7", "Rice", R.drawable.nara));
        tenantList.add(new Tenant("Rocky Rooster", "4.5", "Chicken", R.drawable.rocky));
        tenantList.add(new Tenant("Good Waffle", "4.7", "Snacks", R.drawable.waffle));
        tenantList.add(new Tenant("Nara Kitchen", "4.7", "Rice", R.drawable.nara));
        tenantList.add(new Tenant("Rocky Rooster", "4.5", "Chicken", R.drawable.rocky));
        tenantList.add(new Tenant("Good Waffle", "4.7", "Snacks", R.drawable.waffle));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TenantAdapter(getApplicationContext(), tenantList));



    }
}