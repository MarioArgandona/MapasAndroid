package marioargandona.com.mapasandroid.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import marioargandona.com.mapasandroid.Item;
import marioargandona.com.mapasandroid.R;

/**
 * Created by Robert on 8/26/2016.
 */
public class CustomGridViewAdapter extends ArrayAdapter {

    Context context;
    int layoutResourceId;
    ArrayList<Item> data = new ArrayList<Item>();

    public CustomGridViewAdapter(Context context , int layoutResourceId , ArrayList<Item> data)
    {
        super(context , layoutResourceId , data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId , parent , false);

            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            row.setTag(holder);
        }
        else
        {
            holder = (RecordHolder) row.getTag();
        }
        Item item = data.get(position);
        holder.txtTitle.setText(item.getTitle());
        holder.imageItem.setImageBitmap(item.getImage());
        return row;
    }


    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
    }

}