package com.example.brianr.himasifmobile;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GridAcvtivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    RelativeLayout layout;
    Button wa,line,fb;
    Uri uri;
    String imgurl="http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_acvtivity);
        layout = (RelativeLayout) findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        uri = Uri.parse(""+imgurl);
        wa = (Button)findViewById(R.id.whastapp);
        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "Want to share this";

                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(waIntent.ACTION_VIEW, uri);
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(GridAcvtivity.this, "WhatsApp not Installed", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        fb = (Button) findViewById(R.id.facebook);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                try {

                    Intent fbIntent = new Intent(Intent.ACTION_SEND);
                    fbIntent.setType("text/plain");
                    String text = "Want to share this";

                    PackageInfo info = pm.getPackageInfo("com.facebook", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    fbIntent.setPackage("com.facebook");
                    fbIntent.putExtra(fbIntent.ACTION_VIEW, uri);
                    fbIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(fbIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(GridAcvtivity.this, "Facebook not Installed", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        line = (Button)findViewById(R.id.line);
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "Want to share this";

                    PackageInfo info = pm.getPackageInfo("com.line", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.line");
                    waIntent.putExtra(waIntent.ACTION_VIEW, uri);
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(GridAcvtivity.this, "Line not Installed", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
