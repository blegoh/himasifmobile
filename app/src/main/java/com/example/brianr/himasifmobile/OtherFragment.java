package com.example.brianr.himasifmobile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {
    Button visimisi, tentang_kami, pengurus, aspirasi;

    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        visimisi = (Button)view.findViewById(R.id.visimisi);
        visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),VisiMisi.class);
                startActivity(i);
            }
        });
        tentang_kami = (Button)view.findViewById(R.id.tentang_kami);
        tentang_kami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),TentangKami.class);
                startActivity(i);
            }
        });
        pengurus = (Button)view.findViewById(R.id.pengurus);
        pengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PengurusHimasif.class);
                startActivity(i);
            }
        });
        aspirasi = (Button)view.findViewById(R.id.aspirasi);
        aspirasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aspirasi.class);
                startActivity(i);
            }
        });
        return view;
    }

}
