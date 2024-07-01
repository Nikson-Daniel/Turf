package com.theadvent.turf_dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class DashboardMain extends AppCompatActivity {
    ImageSlider imageSlider;
    ImageView profile, home, transaction, back, menu;

    TextView appBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);
        profile = findViewById(R.id.icProfile);
        home = findViewById(R.id.icHome);
        transaction = findViewById(R.id.icTransaction);
        back = findViewById(R.id.mBack);
        appBarText = findViewById(R.id.appBarTxt);
        menu = findViewById(R.id.mMenu);


        loadFragment(new Dashboard());
        menu.setVisibility(View.VISIBLE);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //BACKICON VISIBILITY
                back.setVisibility(View.VISIBLE);
                //APPBAR TEXT
                appBarText.setText("Profile");
                appBarText.setVisibility(View.VISIBLE);

                loadFragment(new Profile());
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.setVisibility(View.VISIBLE);
                back.setVisibility(View.GONE);
                appBarText.setVisibility(View.GONE);
                loadFragment(new Dashboard());
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //BACKICON VISIBILITY
                back.setVisibility(View.VISIBLE);
                //APPBAR TEXT
                appBarText.setText("Transactions");
                appBarText.setVisibility(View.VISIBLE);
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