package id.ilkom.himasif.himasifmobile;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;



public class ResultRandom extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    RelativeLayout layout;
    private String RESULT;
    private TextView textView;
    private Button share,rerandom;
    private int jumlah_mahasiswa,jumlah_kelompok,jumlah_anggota,jumlah_sisa;
    private String namaMatkul;
    private ScrollView scroll_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        layout = (RelativeLayout)findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        Intent i = getIntent();
        Bundle EXTRA = i.getExtras();
        namaMatkul=EXTRA.getString("matkul");
        jumlah_mahasiswa = EXTRA.getInt("jumlah_mahasiswa");
        jumlah_kelompok = EXTRA.getInt("jumlah_kelompok");
        jumlah_anggota = EXTRA.getInt("jumlah_anggota");
        jumlah_sisa = EXTRA.getInt("jumlah_sisa");

        RESULT = new Random(namaMatkul,jumlah_mahasiswa, jumlah_kelompok, jumlah_anggota, jumlah_sisa).hitung().toString();

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(RESULT);

        onClickListener();
    }
    public void onClickListener(){
        scroll_view = (ScrollView) findViewById(R.id.scroll_view);
        rerandom = (Button) findViewById(R.id.re_random);
        rerandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESULT = new Random(namaMatkul,jumlah_mahasiswa, jumlah_kelompok, jumlah_anggota, jumlah_sisa).hitung().toString();
                textView.setText(RESULT);
                scroll_view.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        share = (Button) findViewById(R.id.share_but);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareTo = new Intent(Intent.ACTION_SEND);
                shareTo.setType("text/plain");
                shareTo.putExtra(Intent.EXTRA_TEXT, RESULT);

                startActivity(Intent.createChooser(shareTo, "Share to"));
            }
        });
    }
}
