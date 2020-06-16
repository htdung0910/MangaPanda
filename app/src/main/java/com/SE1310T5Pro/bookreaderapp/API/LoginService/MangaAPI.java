package com.SE1310T5Pro.bookreaderapp.API.LoginService;

import com.SE1310T5Pro.bookreaderapp.API.Model.Manga.MangaComic;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MangaAPI {
    @GET("manga/hottestManga")
    Call<ArrayList<MangaComic>> loadHosttestManga();
    @GET("manga/genre/{genreID}/{listNum}")
    Call<Map<String, String>> getMangaByGenreID(@Path("genreID") int genreID, @Path("listNum") int listNum);
}
