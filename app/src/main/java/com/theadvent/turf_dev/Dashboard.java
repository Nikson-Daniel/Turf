package com.theadvent.turf_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.theadvent.turf_dev.Adapter.RecyclerAdapter;
import com.theadvent.turf_dev.Data.RecyclerData;
import com.theadvent.turf_dev.Interfaces.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dashboard extends Fragment {

    RecyclerView recyclerView;
    ArrayList<RecyclerData> recyclerDataList;
    RecyclerAdapter recyclerAdapter;

    private List<Post> postList;

    private static final String BASE_URL = "http://192.168.0.2/TurfApi/get_posts.php/";

    public ImageSlider imageSlider;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        postList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerview);

        //IMAGE SLIDER
        imageSlider = view.findViewById(R.id.mImageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();






        recyclerDataList = new ArrayList<>();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Post>> call = apiService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postList = response.body();

                for(int i = 0; i < postList.size(); i++){

                    recyclerDataList.add(new RecyclerData(postList.get(i).getName(),postList.get(i).getDistrict(),postList.get(i).getTiming(),postList.get(i).getDescription(),postList.get(i).getAddress(),postList.get(i).getContact_number(),"₹"+postList.get(i).getPrice()+"/-hour", postList.get(i).getLink1(), postList.get(i).getLink2(), postList.get(i).getLink3(), postList.get(i).getLink4(), postList.get(i).getLink5()));
//                    slideModels.add(new SlideModel(postList.get(i).getLink1(),ScaleTypes.FIT));
//                    slideModels.add(new SlideModel(postList.get(i).getLink1(),ScaleTypes.FIT));
                }

                recyclerAdapter = new RecyclerAdapter(getContext(), recyclerDataList);




                recyclerView.setAdapter(recyclerAdapter);





            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // Handle failure
            }
        });















        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);












    }







    }







