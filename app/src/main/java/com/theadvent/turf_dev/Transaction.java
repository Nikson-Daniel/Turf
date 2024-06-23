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
import com.theadvent.turf_dev.Data.TransactionData;

import java.util.ArrayList;


public class Transaction extends Fragment {

    RecyclerView transactionRecycler;
    ArrayList<TransactionData> transactionDataList;
    TransactionAdapter transactionAdapter;



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

        transactionDataList.add(new TransactionData("1", "12345", "Nikson turf", "1000.00", "Completed", "22-08-2001", "01:45", "01:45 to 02:45"));
        transactionDataList.add(new TransactionData("1", "12345", "Nikson turf", "1000.00", "Completed", "22-08-2001", "01:45", "01:45 to 02:45"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionRecycler.setLayoutManager(layoutManager);
        transactionAdapter = new TransactionAdapter(getContext(), transactionDataList);
        transactionRecycler.setAdapter(transactionAdapter);

        return view;
    }
}