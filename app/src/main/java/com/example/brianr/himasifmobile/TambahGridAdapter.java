package com.example.brianr.himasifmobile;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brian R on 01/01/2018.
 */

public class TambahGridAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<model2>list;

    public TambahGridAdapter(Activity activity, List<model2> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(activity,R.layout.grid,null);
        model2 m = list.get(position);
        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView judul = (TextView)view.findViewById(R.id.judul);
        image.setImageResource(m.getImage());
        judul.setText(m.getText());
        view.setTag(m.getId());
        return view;
    }
}
