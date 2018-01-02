package com.example.brianr.himasifmobile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NimcheckerFragment extends Fragment {
    private ListView listView;
    private TambahListAdapter adapter;
    private List<model>models;

    public NimcheckerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nimchecker, container, false);
        listView = (ListView)view.findViewById(R.id.nimchecker);
        models = new ArrayList<>();

        models.add(new model(1,"Brian","162410101007"));
        adapter = new TambahListAdapter(getActivity(),models);
        listView.setAdapter(adapter);
        return view;
    }

}
