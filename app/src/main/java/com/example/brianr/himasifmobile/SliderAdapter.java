package com.example.brianr.himasifmobile;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Brian R on 04/01/2018.
 */

public class SliderAdapter extends PagerAdapter {
    private int[] image_resources = {
            R.mipmap.himasif1,
            R.drawable.ic_dashboard_black_24dp

    };
    private String [] nama ={
            "Himasif",
            "Dashboard"
    };
    private String [] jabatan = {
            "Ketua",
            "Sekretaris"
    };
    private Context context;
    private LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.slider_image);
        imageView.setImageResource(image_resources[position]);
        TextView name = (TextView)view.findViewById(R.id.nama);
        name.setText(nama[position]);
        TextView jabat = (TextView)view.findViewById(R.id.jabatan);
        jabat.setText(jabatan[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
