package com.SE1310T5Pro.bookreaderapp.API.LoginService;

import com.SE1310T5Pro.bookreaderapp.API.Model.MangaComic;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MangaAPI {
    @GET("manga/hottestManga")
    Call<ArrayList<MangaComic>> loadHosttestManga();
}
