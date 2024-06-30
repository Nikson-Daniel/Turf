package com.theadvent.turf_dev.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
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

    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name, district, timing, description, address, number, price;
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


        }
    }
}
