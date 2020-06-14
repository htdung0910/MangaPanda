package com.SE1310T5Pro.bookreaderapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Top_Rating_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__rating_);
//        loadTopList(R.id.list_top_view, 10, R.drawable.theme_manga, R.layout.item_list);
    }
//    public void loadTopList(int id, int size, int image, int layout_id){
//        ArrayList<ImageItemUpload> items = new ArrayList<>();
//        CustomAdapterList adapter = new CustomAdapterList(this, layout_id, items);
//        ListView listView = findViewById(id);
//        listView.setAdapter(adapter);
//
//
//// let’s create 10 random items
//
//        for (int i = 0; i < size; i++) {
//            items.add(new ImageItemUpload(image, "Title " + i));
//            adapter.notifyDataSetChanged();
//        }
//    }
}
