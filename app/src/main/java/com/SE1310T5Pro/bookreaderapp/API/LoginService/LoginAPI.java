package com.SE1310T5Pro.bookreaderapp.API.LoginService;

import com.SE1310T5Pro.bookreaderapp.API.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginAPI {
    @GET("hottestManga")
    Call<String> getManga();
    @FormUrlEncoded
    @POST("user/login")
    Call<User> checkLogin(@Field("username") String username, @Field("password") String password);
}
