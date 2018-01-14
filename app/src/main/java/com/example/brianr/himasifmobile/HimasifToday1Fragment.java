package com.example.brianr.himasifmobile;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.brianr.himasifmobile.models.wp.Embedded;
import com.example.brianr.himasifmobile.models.wp.Post;
import com.example.brianr.himasifmobile.models.wp.WpFeaturedmediaItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HimasifToday1Fragment extends Fragment {
    private ProgressDialog pDialog;
    private GridView gridView;
    private TambahGridAdapter adapter;
    private List<model2>mlist = new ArrayList<model2>();
    private final String urlHimasif="http://himasif.ilkom.unej.ac.id//wp-json/wp/v2/posts?_embed&per_page=16";


    List<Post> list;
    Gson gson = new Gson();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_himasif_today1, container, false);
        gridView = (GridView)view.findViewById(R.id.grid1);
        adapter = new TambahGridAdapter(getActivity(),mlist);
        gridView.setAdapter(adapter);
        getPost();
        //list = new ArrayList<>();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            model2 m = mlist.get(i);

                String id = String.valueOf(m.getId());
                String title = m.getTitle();
                String isi=m.getIsi();
                String date=m.getDate();
                String link=m.getLink();

                Intent intent = new Intent(getActivity(),GridAcvtivity.class);
                intent.putExtra("postId",id);
                intent.putExtra("title",title);
                intent.putExtra("isi",isi);
                intent.putExtra("date",date);
                intent.putExtra("link",link);

                startActivity(intent);

            }
        });






      /*  list.add(new model2(1,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(2,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(3,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(4,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(5,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(6,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(7,R.drawable.ic_home_black_24dp,"HIMASIF"));
        list.add(new model2(8,R.drawable.ic_home_black_24dp,"HIMASIF"));


        adapter = new TambahGridAdapter(getActivity(),list);
        gridView.setAdapter(adapter);*/
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void getPost(){


        //models.add(new model(1,"Brian","162410101007"));


        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();


        // Creating volley request obj
        StringRequest stringRequest = new StringRequest(Request.Method.GET,urlHimasif,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(String.valueOf(getActivity()), response.toString());


                        // Parsing json
                        list =gson.fromJson(response, new TypeToken<List<Post>>(){}.getType());

                        mlist.clear();
                        for(Post post : list){
                            String image = "";
                            if(post.getFeaturedMedia()>0 && post.getEmbedded().getWpFeaturedmedia()!=null && post.getEmbedded().getWpFeaturedmedia().size()>0){
                                image = post.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
                            }
                            model2 item = new model2(post.getId(),image,Html.fromHtml(post.getTitle().getRendered()).toString());

                            item.setIsi(post.getContent().getRendered());
                            item.setDate(post.getDate());
                            item.setLink(post.getGuid().getRendered());
                            mlist.add(item);
                        }
                        hidePDialog();
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(String.valueOf(getActivity()), "Error: " + error.getMessage());
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
