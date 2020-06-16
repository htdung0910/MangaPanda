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
//        try {
//            InputStream iStream = (InputStream) new URL(items.get(position).getImage()).getContent();
//            Drawable drawable = Drawable.createFromStream(iStream, "drawable");
//            holder.itemImage.setImageResource(Integer.parseInt(items.get(position).getImage()));
//        URL myUrl = null;
//        try {
//            myUrl = new URL(items.get(position).getImage().toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        InputStream inputStream = null;
//        try {
//            inputStream = (InputStream)myUrl.getContent();
//            Drawable drawable = Drawable.createFromStream(inputStream, "drawable");
//            holder.itemImage.setImageDrawable(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        } catch (Exception e) {
//            return null;
//        }
//        Picasso.with(context).load(items.get(position).getImage()).into(holder.itemImage);
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.placeholder(R.drawable.ic_placeholder);
//        requestOptions.error(R.drawable.ic_error);

        Picasso.get().load(items.get(position).getImage()).fit().centerCrop().placeholder(R.drawable.gray_ic).error(R.drawable.ic_error).into(holder.itemImage);


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
            itemImage = view.findViewById(R.id.image);
            itemTitle = view.findViewById(R.id.title);
        }
    }
}
