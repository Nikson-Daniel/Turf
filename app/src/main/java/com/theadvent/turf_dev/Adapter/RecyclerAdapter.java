package com.theadvent.turf_dev.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.theadvent.turf_dev.BookingMain;
import com.theadvent.turf_dev.Data.RecyclerData;
import com.theadvent.turf_dev.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    public Context context;
    public ArrayList<RecyclerData> recyclerDataList;

    public RecyclerAdapter(Context context, ArrayList<RecyclerData> recyclerDataList) {
        this.context = context;
        this.recyclerDataList = recyclerDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_content, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecyclerData recyclerData = recyclerDataList.get(position);
        holder.name.setText(recyclerData.getName());
        holder.address.setText(recyclerData.getAddress());
        holder.district.setText(recyclerData.getDistrict());
        holder.timing.setText(recyclerData.getTiming());
        holder.description.setText(recyclerData.getDescription());
        holder.price.setText(recyclerData.getPrice());
        holder.number.setText(recyclerData.getNumber());

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(recyclerData.getLink1(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(recyclerData.getLink2(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(recyclerData.getLink3(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(recyclerData.getLink4(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(recyclerData.getLink5(), ScaleTypes.FIT));

        holder.imageSlider.setImageList(slideModels);
        holder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link1 = recyclerData.getLink1().toString();
                String link2 = recyclerData.getLink2().toString();
                String link3 = recyclerData.getLink3().toString();
                String link4 = recyclerData.getLink4().toString();
                String link5 = recyclerData.getLink5().toString();
                String turfName = recyclerData.getName().toString();
                String address = recyclerData.getAddress().toString();
                String description = recyclerData.getDescription().toString();

                String[] bk = new String[8];
                bk[0]= link1;
                bk[1]= link2;
                bk[2]= link3;
                bk[3]= link4;
                bk[4]= link5;
                bk[5]= turfName;
                bk[6]= address;
                bk[7]= description;


                Intent intent = new Intent(context, BookingMain.class);
                intent.putExtra("values", bk);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name, district, timing, description, address, number, price;

        public Button booking;
        public ImageSlider imageSlider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.mName);
            district = itemView.findViewById(R.id.mDistrict);
            timing = itemView.findViewById(R.id.mTiming);
            description = itemView.findViewById(R.id.mDescription);
            address = itemView.findViewById(R.id.mAddress);
            number = itemView.findViewById(R.id.mNumber);
            price = itemView.findViewById(R.id.mPrice);
            imageSlider = itemView.findViewById(R.id.mImageSlider);
            booking = itemView.findViewById(R.id.bookNowBtn);


        }
    }
}
