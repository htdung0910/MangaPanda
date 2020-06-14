package com.SE1310T5Pro.bookreaderapp.API.Retrofit;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit retrofit;
    /*private static String url = "https://desolate-atoll-36292.herokuapp.com/";*/
    private static String url = "https://mangapanda.herokuapp.com/";
    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .build();
        }
        return retrofit;
    }
}
