package com.olajideosho.cityguide.User;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.olajideosho.cityguide.HelperClasses.HomeAdapter.CategoryAdapter;
import com.olajideosho.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.olajideosho.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.olajideosho.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.olajideosho.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "UserDashboard";
    RecyclerView featuredRecycler;
    RecyclerView mvRecycler;
    RecyclerView categoryRecycler;
    FeaturedAdapter adapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        mvRecycler = findViewById(R.id.mv_recycler);
        categoryRecycler = findViewById(R.id.category_recycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        featuredRecycler();
        mvRecycler();
        categoryRecycler();



        navigationDrawer();

    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Log.d(TAG, "onNavigationItemSelected: home clicked");
                break;
            case R.id.nav_login:
                Log.d(TAG, "onNavigationItemSelected: login clicked");
                break;
        }
        if(drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //Recycler Functions
    private void categoryRecycler() {
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        String color1 = "#D4CBE5";
        String color2 = "#7ADCCF";
        String color3 = "#F7C59F";
        String color4 = "#B8D7F5";

        ArrayList<FeaturedHelperClass> mostViewed = new ArrayList<>();
        mostViewed.add(new FeaturedHelperClass(R.drawable.restaurant_image, "Restaurant", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda", color1));
        mostViewed.add(new FeaturedHelperClass(R.drawable.restaurant_image, "Educations", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda", color2));
        mostViewed.add(new FeaturedHelperClass(R.drawable.restaurant_image, "Banks", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda", color3));
        mostViewed.add(new FeaturedHelperClass(R.drawable.restaurant_image, "Hotels", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda", color4));
        mostViewed.add(new FeaturedHelperClass(R.drawable.restaurant_image, "Shops", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda", color1));

        CategoryAdapter adapter = new CategoryAdapter(mostViewed);
        categoryRecycler.setAdapter(adapter);
    }

    private void mvRecycler() {
        mvRecycler.setHasFixedSize(true);
        mvRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> mostViewed = new ArrayList<>();
        mostViewed.add(new FeaturedHelperClass(R.drawable.mcdonald_img, "McDonald's", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));
        mostViewed.add(new FeaturedHelperClass(R.drawable.city_1, "Edenbore", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));
        mostViewed.add(new FeaturedHelperClass(R.drawable.city_2, "Sweets and Bakers", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));

        MostViewedAdapter adapter = new MostViewedAdapter(mostViewed);
        mvRecycler.setAdapter(adapter);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0x2077c3, 0xa400ff});

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald_img, "McDonald's", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1, "Edenbore", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Sweets and Bakers", "sdasds sdasdasd dssadasd dasdasds dsadasda dsadasdas dasda"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }


}
