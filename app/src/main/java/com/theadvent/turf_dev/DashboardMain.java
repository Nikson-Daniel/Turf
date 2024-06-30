package com.theadvent.turf_dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class DashboardMain extends AppCompatActivity {
    ImageSlider imageSlider;
    ImageView profile, home, transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);
        profile = findViewById(R.id.icProfile);
        home = findViewById(R.id.icHome);
        transaction = findViewById(R.id.icTransaction);


        loadFragment(new Dashboard());

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Profile());
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Dashboard());
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Transaction());
            }
        });





    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dashboard_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }





}