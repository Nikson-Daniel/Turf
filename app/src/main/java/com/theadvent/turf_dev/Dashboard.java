package com.theadvent.turf_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theadvent.turf_dev.Adapter.RecyclerAdapter;
import com.theadvent.turf_dev.Data.RecyclerData;

import org.w3c.dom.ls.LSOutput;

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
        recyclerDataList = new ArrayList<>();

        recyclerDataList.add(new RecyclerData("Nikson Turf", "Madurai", "12AM-12PM", "A great place for sports.","123 Street, City","9994454208","1000/hr"));
        recyclerDataList.add(new RecyclerData("Nikson Turf2", "Madurai", "12AM-12PM", "A great place for sports.","123 Street, City","9994454208","1000/hr"));
        recyclerDataList.add(new RecyclerData("Nikson Turf", "Madurai", "12AM-12PM", "A great place for sports.","123 Street, City","9994454208","1000/hr"));

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

                System.out.println(postList.get(0).getAddress());
                for(int i = 0; i < postList.size(); i++){
                    recyclerDataList.add(new RecyclerData(postList.get(i).getName(),postList.get(i).getDistrict(),postList.get(i).getTiming(),postList.get(i).getDescription(),postList.get(i).getAddress(),postList.get(i).getContact_number(),postList.get(i).getPrice()));
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


    public void fetchPosts() {
        ArrayList<String> dem = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<Post>> call = apiService.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    if(posts!=null){

                        for (Post post : posts) {
                            Log.d("PostFragment", post.getName());



                        }

                        for (int i = 0; i < posts.size(); i++){
                            pri(posts.get(i).getName(), posts.get(i).getDistrict(), posts.get(i).getTiming(), posts.get(i).getDescription(), posts.get(i).getAddress(), posts.get(i).getContact_number(), posts.get(i).getPrice());
                        }

                    }

                } else {
                    Log.e("PostFragment", "Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("PostFragment", "Network request failed", t);
            }
        });




    }
    ArrayList<String> value = new ArrayList<>();

    void pri(String name, String district, String time, String description, String address, String number, String price){

        recyclerDataList = new ArrayList<>();
        recyclerDataList.add(new RecyclerData(name, district, time, description, address, number, price));
        System.out.println(recyclerDataList.size());




    }





}