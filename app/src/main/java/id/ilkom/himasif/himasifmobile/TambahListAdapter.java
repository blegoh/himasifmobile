package id.ilkom.himasif.himasifmobile;

import android.app.Activity;
import android.graphics.Typeface;
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
    Typeface tf1;
    TextView nama, nim;


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
        View v = View.inflate(activity, R.layout.list_nim,null);
        nama = (TextView)v.findViewById(R.id.nama);
        nim = (TextView)v.findViewById(R.id.nim);
        model m = modelList.get(position);
        nama.setText(m.getNama());
        nim.setText(m.getNim());
        tf1 = Typeface.createFromAsset(v.getResources().getAssets(),"fonts/Roboto-Regular.ttf");
        nama.setTypeface(tf1);
        tf1 = Typeface.createFromAsset(v.getResources().getAssets(),"fonts/Athena of the Ocean.ttf");
        nim.setTypeface(tf1);
        v.setTag(m.getId());
        return v;
    }
}
