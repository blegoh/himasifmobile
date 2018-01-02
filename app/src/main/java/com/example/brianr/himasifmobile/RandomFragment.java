package com.example.brianr.himasifmobile;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {
    CircularProgressButton button;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        button = (CircularProgressButton)view.findViewById(R.id.random_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask<String,String,String> demoLogin = new AsyncTask<String, String, String>() {
                    @Override
                    protected String doInBackground(String... strings) {
                        try{
                            Thread.sleep(3000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        return "done";
                    }
                    @Override
                    protected void onPostExecute(String s){
                        if (s.equals("done")){
                            Intent i = new Intent(getActivity(), Random.class);
                            startActivity(i);
                        }
                    }
                };
                button.startAnimation();
                demoLogin.execute();
            }
        });
        return view;
    }

}
