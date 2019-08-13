package com.example.unsplashmvvm.Model.Network;

import androidx.lifecycle.LiveData;

import com.example.unsplashmvvm.Model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoApi {
    @GET("photos")
    Call<List<Photo>> LIST_CALL_PHOTOS(@Query("page") String page , @Query("client_id") String clientId);
}
