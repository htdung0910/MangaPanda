package dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.SE1310T5Pro.bookreaderapp.R;

import java.util.ArrayList;

import utils.ImageItemUpload;

public class CustomAdapterList extends ArrayAdapter<ImageItemUpload> {
    private Context context;
    private ArrayList<ImageItemUpload> items;
    private int layout_id;



    public CustomAdapterList(Context context, int layout_id, ArrayList<ImageItemUpload> items) {
        super(context, layout_id, items);
        this.context = context;
        this.items = items;
        this.layout_id = layout_id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout_id, null);

        }
        ImageItemUpload item_current = items.get(position);

        ImageView view = convertView.findViewById(R.id.item);
//        view.setImageResource(item_current.getImage());
        TextView text = convertView.findViewById(R.id.item_text);
        text.setText(item_current.getTitle());
        return convertView;
    }
}
