package com.example.unsplashmvvm.Model.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit sRetrofit;
    private static String BASE_URL = "https://api.unsplash.com";

    private RetrofitInstance() {

    }

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            synchronized (RetrofitInstance.class) {
                sRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return sRetrofit;
    }
}
