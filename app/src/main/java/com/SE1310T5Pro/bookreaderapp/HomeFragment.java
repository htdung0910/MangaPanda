package com.SE1310T5Pro.bookreaderapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.SE1310T5Pro.bookreaderapp.API.LoginService.MangaAPI;
import com.SE1310T5Pro.bookreaderapp.API.Model.MangaComic;
import com.SE1310T5Pro.bookreaderapp.API.Retrofit.RetrofitConfig;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import dao.CustomAdapter;
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
                //recommend
//        loadRecommendList(R.id.view_grid, 4, R.drawable.bg_mgvie, R.layout.move_card_grid, v);
//        //type_comic
//        loadRecommendList(R.id.view_type_grid_1, 3, R.drawable.bg_manga, R.layout.type__comic_items, v);
//        loadRecommendList(R.id.view_type_grid_2, 3, R.drawable.bg_mangavie, R.layout.type__comic_items, v);
//        loadRecommendList(R.id.view_type_grid_3, 3, R.drawable.slider2, R.layout.type__comic_items, v);
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
                comicList.addAll(response.body());
                for (int i = 0; i < comicList.size(); i++) {

                    items.add(new ImageItemUpload(comicList.get(i).getThumnailpath(), comicList.get(i).getTitle()));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MangaComic>> call, Throwable t) {

            }
        });

    }
//    public void loadRecommendList(int id, int size, int image, int layout_id, View v){
//        ArrayList<ImageItemUpload> items = new ArrayList<>();
//        CustomAdapterGrid adapter = new CustomAdapterGrid(getContext(), items, layout_id);
//        GridView gridView = v.findViewById(id);
//        gridView.setAdapter(adapter);
//
//
//// let’s create 10 random items
//
//        for (int i = 0; i < size; i++) {
//            items.add(new ImageItemUpload(image, "Title " + i));
//            adapter.notifyDataSetChanged();
//        }
//    }
    public void moveActivity(Button button, final Class c){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_activity = new Intent(getContext(), c);
                startActivity(intent_activity);
            }
        });
    }
}
