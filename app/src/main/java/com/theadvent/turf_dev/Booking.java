package com.theadvent.turf_dev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Booking extends Fragment {

    String  link2, link3, link4, link5, turfName, address, description;

    ImageView img2, img3, img4, img5;

    TextView mTurfName, mAddress, mDescription;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        img4 = view.findViewById(R.id.img4);
        img5 = view.findViewById(R.id.img5);
        mTurfName = view.findViewById(R.id.bTurfName);
        mAddress = view.findViewById(R.id.bAddress);
        mDescription = view.findViewById(R.id.bDescription);


        String[] val = getArguments().getStringArray("values");


        link2 = val[1];
        link3 = val[2];
        link4 = val[3];
        link5 = val[4];
        turfName = val[5];
        address = val[6];
        description = val[7];

        Glide.with(this).load(link2).into(img2);
        Glide.with(this).load(link3).into(img3);
        Glide.with(this).load(link4).into(img4);
        Glide.with(this).load(link5).into(img5);
        mTurfName.setText(turfName);
        mAddress.setText(address);
        mDescription.setText(description);


        return view;
    }
}