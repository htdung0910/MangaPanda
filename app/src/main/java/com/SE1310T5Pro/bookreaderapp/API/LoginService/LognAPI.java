package com.SE1310T5Pro.bookreaderapp.API.LoginService;

import com.SE1310T5Pro.bookreaderapp.API.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LognAPI {

    @POST("user/login")
    @FormUrlEncoded
    Call<User> checkLogin(@Field("username") String username, @Field("password") String password);
}
