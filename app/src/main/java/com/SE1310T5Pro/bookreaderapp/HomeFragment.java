package com.SE1310T5Pro.bookreaderapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.SE1310T5Pro.bookreaderapp.API.LoginService.MangaAPI;
import com.SE1310T5Pro.bookreaderapp.API.Model.Manga.MangaComic;
import com.SE1310T5Pro.bookreaderapp.API.Retrofit.RetrofitConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dao.CustomAdapter;
import dao.CustomAdapterGrid;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.ImageItemUpload;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    int[] images;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        images = new int[]{
                R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4
        };

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        //loadSlider
        loadSlider(v);
        loadHotList(R.id.recycler_view, v);
        //random
        Random random = new Random();
        int random_number = random.nextInt(54);
                //recommend
        loadRecommendList(R.id.view_grid, R.layout.move_card_grid, v, random_number, 4);
        //type_comic
        loadRecommendList(R.id.view_type_grid_1, R.layout.type__comic_items, v, 18, 4);
        loadRecommendList(R.id.view_type_grid_2, R.layout.type__comic_items, v, 4, 4);
        loadRecommendList(R.id.view_type_grid_3,R.layout.type__comic_items, v, 22, 4);
        //move Activity
        Button rating_bt = v.findViewById(R.id.rating_btn);
        moveActivity(rating_bt, Top_Rating_Activity.class);
        return v;

    }

    public void loadSlider(View v) {
        CarouselView carouselView = (CarouselView) v.findViewById(R.id.slider);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
//                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(images[position]);

            }
        });
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {

            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void loadHotList(int id, final View v) {
        final ArrayList<ImageItemUpload> items = new ArrayList<>();
        final CustomAdapter adapter = new CustomAdapter(getContext(), items);
        RecyclerView recyclerView = v.findViewById(id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(adapter);
        //call api
        MangaAPI mangaAPI = RetrofitConfig.getRetrofitInstance().create(MangaAPI.class);
        final ArrayList<MangaComic> comicList = new ArrayList<>();
        Call<ArrayList<MangaComic>> hottestList = mangaAPI.loadHosttestManga();
        hottestList.enqueue(new Callback<ArrayList<MangaComic>>() {
            @Override
            public void onResponse(Call<ArrayList<MangaComic>> call, Response<ArrayList<MangaComic>> response) {
                if(response.isSuccessful()){
                    comicList.addAll(response.body());
                    for (int i = 0; i < comicList.size(); i++) {

                        items.add(new ImageItemUpload(comicList.get(i).getThumnailpath(), comicList.get(i).getTitle()));
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MangaComic>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

        public void loadRecommendList(int id, int layout_id, View v, int genres_id, final int total_num){
        final ArrayList<ImageItemUpload> items = new ArrayList<>();
        final CustomAdapterGrid adapter = new CustomAdapterGrid(getContext(), items, layout_id);
        final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        GridView gridView = v.findViewById(id);
        gridView.setAdapter(adapter);
            MangaAPI mangaAPI = RetrofitConfig.getRetrofitInstance().create(MangaAPI.class);
            final ArrayList<MangaComic> comicList = new ArrayList<>();
            Call<Map<String, String>> type_list = mangaAPI.getMangaByGenreID(genres_id, total_num);
            type_list.enqueue(new Callback<Map<String, String>>() {
                @Override
                public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                    if(response.isSuccessful()){
                        comicList.addAll((Collection<? extends MangaComic>) gson.fromJson(response.body().get("books"),new TypeToken<List<MangaComic>>() {}.getType()));
                        // let’s create 10 random items
                        for (int i = 0; i < comicList.size(); i++) {
                            items.add(new ImageItemUpload(comicList.get(i).getThumnailpath(), comicList.get(i).getTitle()));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Map<String, String>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        onClickGridViewEvent(gridView);



    }
    public void moveActivity(Button button, final Class c){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_activity = new Intent(getContext(), c);
                startActivity(intent_activity);
            }
        });
    }

     protected void onClickGridViewEvent(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Chapter_ViewActivity.class);
//                intent.putExtra("name",fruitNames[i]);
//                intent.putExtra("image",fruitImages[i]);
                startActivity(intent);
            }
        });
    }
}
