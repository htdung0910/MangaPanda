package com.SE1310T5Pro.bookreaderapp;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class HomepageActivity extends AppCompatActivity{
    private int[] images = new int[]{
      R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4
    };
    private ArrayList<utils.ImageItemUpload> listUpdate = new ArrayList<>();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_homepage);
       createBottom_Nav();

//        //type_comic
//        loadRecommendList(R.id.view_type_grid_1, 3, R.drawable.bg_manga, R.layout.type__comic_items);
//        loadRecommendList(R.id.view_type_grid_2, 3, R.drawable.bg_mangavie, R.layout.type__comic_items);
//        loadRecommendList(R.id.view_type_grid_3, 3, R.drawable.slider2, R.layout.type__comic_items);
//
        //move Activity
//        Button rating_bt = findViewById(R.id.rating_btn);
//        moveActivity(rating_bt, Top_Rating_Activity.class);
    }

//    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
//        Window win = activity.getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }




    public void createBottom_Nav(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment index = null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    index = new HomeFragment();
                    break;
                case R.id.nav_seach:
                    index = new SearchFragment();
                    break;
                case R.id.nav_user:
                    index = new LoginFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, index).commit();
            return true;
        }
    };
}
