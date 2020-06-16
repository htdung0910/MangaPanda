package dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.SE1310T5Pro.bookreaderapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import utils.ImageItemUpload;

public class CustomAdapterGrid extends BaseAdapter  {

    private Context context;
    private ArrayList<ImageItemUpload> items;
    private int layout_id;

    public CustomAdapterGrid(Context context, ArrayList<ImageItemUpload> items, int layout_id) {
        this.context = context;
        this.items = items;
        this.layout_id = layout_id;
    }

//    @NonNull
//    @Override
//    public CustomViewHolderGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new CustomViewHolderGrid(LayoutInflater.from(context).inflate(R.layout.move_card_grid, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CustomViewHolderGrid holder, int position) {
//        holder.itemTitle.setText(items.get(position).getTitle());
//        holder.itemImage.setImageResource(items.get(position).getImage());
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolderGrid holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout_id, parent, false);
            holder = new CustomViewHolderGrid(convertView);
            holder.itemTitle.setText(items.get(position).getTitle());
            Picasso.get().load(items.get(position).getImage()).fit().centerCrop().placeholder(R.drawable.gray_ic).error(R.drawable.ic_error).into(holder.itemImage);
        } else {
            holder = (CustomViewHolderGrid) convertView.getTag();
        }
        return convertView;
    }

    public class CustomViewHolderGrid extends RecyclerView.ViewHolder {

        private ImageView itemImage;
        private TextView itemTitle;

        public CustomViewHolderGrid(View view) {
            super(view);
            itemImage = view.findViewById(R.id.image);
            itemTitle = view.findViewById(R.id.title);
        }
    }
}
