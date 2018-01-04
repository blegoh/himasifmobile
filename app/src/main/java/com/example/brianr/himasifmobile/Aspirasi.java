package com.example.brianr.himasifmobile;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Aspirasi extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    EditText aspirasi;
    RelativeLayout layout;
    Button kirim;
    Spinner kategori,jenis_aspirasi;
    //a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspirasi);
        layout = (RelativeLayout)findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        kategori = (Spinner)findViewById(R.id.kategori);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Kategori, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kategori.setAdapter(adapter1);
        jenis_aspirasi = (Spinner)findViewById(R.id.jenis_aspirasi);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Jenis_Aspirasi, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenis_aspirasi.setAdapter(adapter2);
        aspirasi = (EditText) findViewById(R.id.aspirasi);
        kirim = (Button) findViewById(R.id.kirim);
    }
}
