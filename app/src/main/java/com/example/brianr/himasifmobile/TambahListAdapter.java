package com.example.brianr.himasifmobile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brian R on 28/12/2017.
 */

public class TambahListAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<model>modelList;

    public TambahListAdapter(Activity activity, List<model> modelList) {
        this.activity = activity;
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(activity,R.layout.list_nim,null);
        TextView nama = (TextView)v.findViewById(R.id.nama);
        TextView nim = (TextView)v.findViewById(R.id.nim);
        model m = modelList.get(position);
        nama.setText(m.getNama());
        nim.setText(m.getNim());
        v.setTag(m.getId());
        return v;
    }
}
