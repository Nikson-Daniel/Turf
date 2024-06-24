package com.theadvent.turf_dev.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theadvent.turf_dev.Data.RecyclerData;
import com.theadvent.turf_dev.Data.TransactionData;
import com.theadvent.turf_dev.R;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>{

    public Context context;
    public ArrayList<TransactionData> transactionDataList;

    public TransactionAdapter(Context context, ArrayList<TransactionData> transactionDataList) {
        this.context = context;
        this.transactionDataList = transactionDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.transaction_content, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TransactionData transactionData = transactionDataList.get(position);
        holder.sNo.setText(transactionData.getsNo());
        holder.transactionId.setText(transactionData.getTransactionId());
        holder.turfName.setText(transactionData.getTurfName());
        holder.price.setText(transactionData.getPrice());
        holder.status.setText(transactionData.getStatus());
        holder.date.setText(transactionData.getDate());
        holder.time.setText(transactionData.getTime());
        holder.timing.setText(transactionData.getTiming());


    }

    @Override
    public int getItemCount() {
        return transactionDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView sNo, transactionId, turfName, price, status, date, time, timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sNo = itemView.findViewById(R.id.mSno);
            transactionId = itemView.findViewById(R.id.mTransactionId);
            turfName = itemView.findViewById(R.id.mTurfName);
            price = itemView.findViewById(R.id.mPrice);
            status = itemView.findViewById(R.id.mStatus);
            date = itemView.findViewById(R.id.mDate);
            time = itemView.findViewById(R.id.mTime);
            timing = itemView.findViewById(R.id.mTiming);
        }
    }
}
