package com.example.brianr.himasifmobile;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {
    Button random, reset;
    private String namaMatkul;
    private int jumlah_mahasiswa, jumlah_kelompok, jumlah_anggota, jumlah_sisa;
    private MaterialEditText mahasiswa, kelompok, anggota, sisa, matkul;
    private TextWatcher watcher_k, watcher_a;
    ScrollView scroll;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        scroll = (ScrollView) view.findViewById(R.id.scroll);
        matkul = (MaterialEditText)view.findViewById(R.id.matkul);
        mahasiswa = (MaterialEditText) view.findViewById(R.id.jmlMhs);
        kelompok = (MaterialEditText) view.findViewById(R.id.jmlKlp);
        anggota = (MaterialEditText) view.findViewById(R.id.jmlAgt);
        sisa = (MaterialEditText) view.findViewById(R.id.jmlSisa);
        sisa.setEnabled(false);
        watcher_k = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                anggota.removeTextChangedListener(watcher_a);
                if (!kelompok.getText().toString().equals("") && !kelompok.getText().toString().equals("0") && !mahasiswa.getText().toString().equals("")) {
                    jumlah_mahasiswa = Integer.parseInt(mahasiswa.getText().toString());
                    jumlah_kelompok = Integer.parseInt(kelompok.getText().toString());
                    namaMatkul=matkul.getText().toString();

                    jumlah_anggota = jumlah_mahasiswa / jumlah_kelompok;
                    jumlah_sisa = jumlah_mahasiswa % jumlah_kelompok;

                    anggota.setText(jumlah_anggota + "");
                    sisa.setText(jumlah_sisa + "");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        watcher_a = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                kelompok.removeTextChangedListener(watcher_k);
                if (!anggota.getText().toString().equals("") && !anggota.getText().toString().equals("0") && !mahasiswa.getText().toString().equals("")) {
                    jumlah_mahasiswa = Integer.parseInt(mahasiswa.getText().toString());
                    jumlah_anggota = Integer.parseInt(anggota.getText().toString());

                    jumlah_kelompok = jumlah_mahasiswa / jumlah_anggota;
                    jumlah_sisa = jumlah_mahasiswa % jumlah_anggota;

                    sisa.setText(jumlah_sisa + "");
                    kelompok.setText(jumlah_kelompok + "");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        kelompok.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    kelompok.addTextChangedListener(watcher_k);
            }
        });
        anggota.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                anggota.addTextChangedListener(watcher_a);
            }
        });
        random = (Button) view.findViewById(R.id.random_button);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RES = new Intent(getActivity(), ResultRandom.class);
                if (mahasiswa.getText().toString().equals("") || kelompok.getText().toString().equals("") ||
                        anggota.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Silahkan isi semua kolom", Toast.LENGTH_LONG).show();
                    return;
                }
                Bundle EXTRA = new Bundle();
                EXTRA.putString("matkul",namaMatkul);
                EXTRA.putInt("jumlah_mahasiswa", jumlah_mahasiswa);
                EXTRA.putInt("jumlah_kelompok", jumlah_kelompok);
                EXTRA.putInt("jumlah_anggota", jumlah_anggota);
                EXTRA.putInt("jumlah_sisa", jumlah_sisa);
                RES.putExtras(EXTRA);
                startActivity(RES);
            }
        });
        reset = (Button) view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matkul.setText("");
                mahasiswa.setText("");
                kelompok.setText("");
                anggota.setText("");
                sisa.setText("");
                anggota.removeTextChangedListener(watcher_a);
                kelompok.removeTextChangedListener(watcher_k);
            }
        });
        return view;
    }

}
