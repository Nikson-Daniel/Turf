package com.theadvent.turf_dev.Interfaces;

import com.theadvent.turf_dev.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("get_posts.php")
    Call<List<Post>> getPosts();
}
