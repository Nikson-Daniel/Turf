package com.theadvent.turf_dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BookingMain extends AppCompatActivity {

    ImageView img1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_main);

        Intent intent = getIntent();
        String val[] = intent.getStringArrayExtra("values");


//        for (int i = 0; i < val.length; i++){
//            System.out.println(val[i]);
//        }


        img1 = findViewById(R.id.img1);
        Glide.with(this).load(val[0]).into(img1);
        loadFragment(new Booking(), val);



    }

    public void loadFragment(Fragment fragment, String[] val){
        Bundle bundle = new Bundle();
        bundle.putStringArray("values", val);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bookingMain, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}