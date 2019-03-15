package com.github.Andryyr.task4;

import com.github.Andryyr.task4.Gson.MyGson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface DownloaderInterface {
    @GET("/search/photos")
    Call<MyGson> getData(@Query("query") String resourceName , @Query("client_id") String client_id);
}
