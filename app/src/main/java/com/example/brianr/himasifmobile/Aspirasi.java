package com.example.brianr.himasifmobile;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Aspirasi extends AppCompatActivity {
    private final String urlAspirasi = "http://himasif.ilkom.unej.ac.id/aspirasi/aspirasi.php?apicall=insert_aspirasi";
    AnimationDrawable animationDrawable;
    EditText aspirasi;
    RelativeLayout layout;
    private String pengusul,  isi_usulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspirasi);
        layout = (RelativeLayout) findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        aspirasi = (EditText) findViewById(R.id.aspirasi);

    }

    public void kirim(View view) {
        isi_usulan = aspirasi.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlAspirasi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jObj = new JSONObject(response);
                            boolean status = jObj.getBoolean("status");
                            if (status) {

                                Toast.makeText(getApplicationContext(), "Terimakasih atas Aspirasi yang anda kirimkan", Toast.LENGTH_SHORT).show();
                                onBackPressed();

                            } else {

                                String errorMsg = jObj.getString("error_msg");
                                Toast.makeText(getApplicationContext(),
                                        errorMsg, Toast.LENGTH_LONG).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Aspirasi.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("isi_usulan", isi_usulan);

                return map;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
