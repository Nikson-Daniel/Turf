package com.theadvent.turf_dev.Interfaces;

import com.theadvent.turf_dev.Bookings;
import com.theadvent.turf_dev.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceTransaction {
    @GET("get_transaction.php")
    Call<List<Bookings>> getTransaction();
}
