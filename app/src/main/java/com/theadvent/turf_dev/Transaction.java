package com.theadvent.turf_dev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theadvent.turf_dev.Adapter.RecyclerAdapter;
import com.theadvent.turf_dev.Adapter.TransactionAdapter;
import com.theadvent.turf_dev.Data.RecyclerData;
import com.theadvent.turf_dev.Data.TransactionData;
import com.theadvent.turf_dev.Interfaces.ApiServiceTransaction;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Transaction extends Fragment {

    RecyclerView transactionRecycler;
    ArrayList<TransactionData> transactionDataList;
    TransactionAdapter transactionAdapter;

    private List<Bookings> postList;

    private static final String BASE_URL = "http://192.168.0.2/TurfApi/get_transaction.php/";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        transactionRecycler = view.findViewById(R.id.mTransactionRecycler);
        transactionDataList = new ArrayList<>();
        postList = new ArrayList<>();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionRecycler.setLayoutManager(layoutManager);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServiceTransaction apiService = retrofit.create(ApiServiceTransaction.class);
        Call<List<Bookings>> call = apiService.getTransaction();


        call.enqueue(new Callback<List<Bookings>>() {
            @Override
            public void onResponse(Call<List<Bookings>> call, Response<List<Bookings>> response) {
                postList = response.body();

                for(int i = 0; i < postList.size(); i++){
                    transactionDataList.add(new TransactionData(String.valueOf(i+1), postList.get(i).getBookingId(), postList.get(i).getTurfName(), "₹"+postList.get(i).getAmount(), postList.get(i).getStatus(), postList.get(i).getDate(), postList.get(i).getTime(), postList.get(i).getTiming()));
                }
                transactionAdapter = new TransactionAdapter(getContext(), transactionDataList);
                transactionRecycler.setAdapter(transactionAdapter);

            }



            @Override
            public void onFailure(Call<List<Bookings>> call, Throwable t) {
                // Handle failure
            }
        });

        return view;
    }
}