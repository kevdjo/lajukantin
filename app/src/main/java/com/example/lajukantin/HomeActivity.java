package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;
import com.example.lajukantin.Adaptor.CategoryAdaptor;
import com.example.lajukantin.Domain.CategoryDomain;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //slider
        ViewPager2 viewPager2 = findViewById(R.id.smartSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.slideshow1,"Image 1"));
        sliderItems.add(new SliderItem(R.drawable.slideshow2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.slideshow3,"Image 3"));
        sliderItems.add(new SliderItem(R.drawable.slideshow4,"Image 4"));
        sliderItems.add(new SliderItem(R.drawable.slideshow5,"Image 5"));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,5000));

        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Have A Great Day", Toast.LENGTH_SHORT).show();
        });

        recyclerViewCategory();
        bottomNavigation();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView2);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Good Waffle", "waffle"));
        category.add(new CategoryDomain("Nara Kitchen", "nara"));
        category.add(new CategoryDomain("Rocky Rooster", "rocky"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout resBtn = findViewById(R.id.resBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TenantActivity.class));
            }
        });
    }
}