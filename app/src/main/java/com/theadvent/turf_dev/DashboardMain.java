package com.theadvent.turf_dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class DashboardMain extends AppCompatActivity {
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        //imageSlider = findViewById(R.id.dddd);

        loadFragment(new Dashboard());
//        loadFragment(new Transaction());

//        ArrayList<SlideModel> slideModels = new ArrayList<>();
//        slideModels.add(new SlideModel("https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=600", ScaleTypes.FIT));
//        slideModels.add(new SlideModel("https://images.pexels.com/photos/1413412/pexels-photo-1413412.jpeg?auto=compress&cs=tinysrgb&w=600", ScaleTypes.FIT));
//
//        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dashboard_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }





}