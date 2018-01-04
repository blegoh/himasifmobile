package com.example.brianr.himasifmobile;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.rengwuxian.materialedittext.MaterialEditText;

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
public class NimcheckerFragment extends Fragment {
    private static final String url="http://himasif.ilkom.unej.ac.id/nimchecker/resultMobile.php";
    private ProgressDialog pDialog;
    private ListView listView;
    private TambahListAdapter adapter;
    private List<model>models;
    private Button btnCari;
    private MaterialEditText search;

    public NimcheckerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nimchecker, container, false);
        btnCari=(Button)view.findViewById(R.id.btn_cari);
        search=(MaterialEditText) view.findViewById(R.id.search);
        search.requestFocus();

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNim();
                hideKeyboardFrom(getActivity(),view);
            }
        });


        listView = (ListView)view.findViewById(R.id.nimchecker);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                model m = models.get(position);
                String result = m.getNama()+"\n"+m.getNim()+"\n\nCopyright \u00a9 HIMASIF UNEJ";
                Intent shareTo = new Intent(Intent.ACTION_SEND);
                shareTo.setType("text/plain");
                shareTo.putExtra(Intent.EXTRA_TEXT,result);

                startActivity(Intent.createChooser(shareTo, "Share to"));
            }
        });

        return view;
    }

    public void getNim(){
        models = new ArrayList<>();

        //models.add(new model(1,"Brian","162410101007"));
        adapter = new TambahListAdapter(getActivity(),models);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();


        // Creating volley request obj
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(String.valueOf(getActivity()), response.toString());
                        hidePDialog();

                        // Parsing json

                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONArray jsonArray = obj.getJSONArray("data");
                            for(int i=0; i<jsonArray.length(); i++) {
                                JSONObject objMahasiswa = jsonArray.getJSONObject(i);
                                final model mMahasiswa = new model();

                                mMahasiswa.setId(i);
                                mMahasiswa.setNim(objMahasiswa.getString("nim"));
                                mMahasiswa.setNama(objMahasiswa.getString("nama"));


                                // Genre is json array
                                /*JSONArray jualanArray = obj.getJSONArray("data");*/
                                ArrayList<String> mahasiswa = new ArrayList<String>();
                             
                                models.add(mMahasiswa);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
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
                map.put("nim",search.getText().toString());
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
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
