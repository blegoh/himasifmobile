package com.example.brianr.himasifmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.brianr.himasifmobile.models.wp.Post;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridAcvtivity extends AppCompatActivity {
    List<Post> list;
    Gson gson = new Gson();
    AnimationDrawable animationDrawable;
    RelativeLayout layout;
    Button wa, line, fb,btnShare;
    Uri uri;
    String imgurl = "http://www.google.com";
    private WebView isi;
    private ProgressDialog pDialog;
    private TextView judul,tanggal,sumber;
    private List<model2>mlist = new ArrayList<model2>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_acvtivity);
        layout = (RelativeLayout) findViewById(R.id.layout);

        final String id = getIntent().getExtras().getString("postId");
        final String title = getIntent().getExtras().getString("title");
        final String content = getIntent().getExtras().getString("isi");
        final String date = getIntent().getExtras().getString("date");
        final String link = getIntent().getExtras().getString("link");


        isi=(WebView)findViewById(R.id.isi);
        judul=(TextView)findViewById(R.id.judul);
        tanggal=(TextView)findViewById(R.id.tanggalTerbit);
        sumber=(TextView)findViewById(R.id.sumber);
        btnShare=(Button)findViewById(R.id.btnShare);

     /*   WebSettings settings = isi.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);*/

        judul.setText(title);
        tanggal.setText(date);
        sumber.setText(link);
        isi.loadDataWithBaseURL(null,"<style>img{display: inline;height: auto;max-width: 100%;}</style>"+content.toString(),"text/html","UTF-8",null);


        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareTo = new Intent(Intent.ACTION_SEND);
                shareTo.setType("text/plain");
                shareTo.putExtra(Intent.EXTRA_TEXT,title+"\n"+link+"\n\n"+"Copyright \u00a9 HIMASIF UNEJ");

                startActivity(Intent.createChooser(shareTo, "Share to"));
            }
        });

      /*  uri = Uri.parse("" + imgurl);
        wa = (Button) findViewById(R.id.whatsapp);
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
                    waIntent.putExtra(Intent.EXTRA_TEXT, link);
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
        line = (Button) findViewById(R.id.line);
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
        });*/

       // getDetailPost();


    }

    public void getDetailPost() {


        final String urlPost = "http://himasif.ilkom.unej.ac.id//wp-json/wp/v2/posts/" + "id" + "?fields=title,content";


        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();


        // Creating volley request obj
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPost,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(String.valueOf(this), response.toString());


                        // Parsing json
                        list = gson.fromJson(response, new TypeToken<List<Post>>() {
                        }.getType());

                        // mlist.clear();
                        for (Post post : list) {
                            String image = "";
                            String title = "";
                            String content = "";

                            title = post.getTitle().getRendered();
                            content = post.getContent().getRendered();

                            judul.setText(title);
                            isi.loadData(content.toString(),"text/html","UTF-8");


                          /*
                            if(post.getFeaturedMedia()>0 && post.getEmbedded().getWpFeaturedmedia()!=null && post.getEmbedded().getWpFeaturedmedia().size()>0){
                                image = post.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
                            }
                            model2 item = new model2(post.getId(),image, Html.fromHtml(post.getTitle().getRendered()).toString());
                            mlist.add(item);*/
                        }
                        hidePDialog();
                        // adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(String.valueOf(this), "Error: " + error.getMessage());
                hidePDialog();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                return map;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
