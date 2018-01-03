package com.example.brianr.himasifmobile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HimasifToday1Fragment extends Fragment {
    private GridView gridView;
    private TambahGridAdapter adapter;
    private List<model2>list = new ArrayList<model2>();

    public HimasifToday1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_himasif_today1, container, false);
        gridView = (GridView)view.findViewById(R.id.grid1);
        list = new ArrayList<>();

        list.add(new model2(1,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(2,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(3,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(4,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(5,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(6,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(7,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(8,R.drawable.ic_home_black_24dp,"HIMASIF"));


        adapter = new TambahGridAdapter(getActivity(),list);
        gridView.setAdapter(adapter);
        return view;
    }

}
