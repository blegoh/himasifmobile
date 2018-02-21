package id.ilkom.himasif.himasifmobile;

import android.graphics.drawable.AnimationDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Aspirasi extends AppCompatActivity {
    private final String urlAspirasi = "http://himasif.ilkom.unej.ac.id/aspirasi/aspirasi.php?apicall=insert_aspirasi";
    private final String SITE_KEY = "6LdXuEYUAAAAAPFrxw1EFGCc_bm-ts1DEs9IELWJ";
    private final String SECRET_KEY = "6LdXuEYUAAAAAHSVoayohS4iLm7-pO5rS8vCzJ8O";
    AnimationDrawable animationDrawable;
    EditText aspirasi;
    RelativeLayout layout;
    private String pengusul,  isi_usulan;
    String userResponseToken;
    private Toolbar toolbar;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspirasi);
//        layout = (RelativeLayout) findViewById(R.id.layout);
//        animationDrawable = (AnimationDrawable) layout.getBackground();
//        animationDrawable.setEnterFadeDuration(4500);
//        animationDrawable.setExitFadeDuration(4500);
//        animationDrawable.start();
        aspirasi = (EditText) findViewById(R.id.aspirasi);
        toolbar = (Toolbar)findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kritik Saran");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }

    }
    public void kirim(View view) {
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY).addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
            @Override
            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                userResponseToken = response.getTokenResult();
                if (!userResponseToken.isEmpty()){
                    sendRequest();
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ApiException){
                    ApiException apiException = (ApiException) e;
                    Log.d(TAG, "Error message: " +
                            CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                } else {
                    Log.d(TAG, "Unknown type of error: " + e.getMessage());
                }
            }
        });
    }

    private void sendRequest(){
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
