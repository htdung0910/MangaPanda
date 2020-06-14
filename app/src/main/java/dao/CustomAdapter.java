package dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SE1310T5Pro.bookreaderapp.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import utils.ImageItemUpload;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>  {

    private Context context;
    private ArrayList<ImageItemUpload> items;


    public CustomAdapter(Context context, ArrayList<ImageItemUpload> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.move_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.itemTitle.setText(items.get(position).getTitle());
        Picasso.get().setLoggingEnabled(true);
        Picasso.get()
                .load(items.get(position).getImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(holder.itemImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        //do smth when picture is loaded successfully

                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemImage;
        private TextView itemTitle;


        public CustomViewHolder(View view) {
            super(view);
            itemImage = view.findViewById(R.id.imgLoad);
            itemTitle = view.findViewById(R.id.imgDesc);
        }
    }
}
