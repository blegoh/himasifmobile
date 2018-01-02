package com.example.brianr.himasifmobile;

import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    Animation frombottom;
    RelativeLayout layout, fragment;
    TextView textView;
    

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    textView = (TextView)findViewById(R.id.title);
                    textView.setText("HIMASIF TODAY");
                    HomeFragment homeFragment = new HomeFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, homeFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_nimchecker:
                    textView = (TextView)findViewById(R.id.title);
                    textView.setText("NIMCHECKER");
                    NimcheckerFragment nimcheckerFragment = new NimcheckerFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment, nimcheckerFragment);
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_random:
                    textView = (TextView)findViewById(R.id.title);
                    textView.setText("RANDOM");
                    RandomFragment randomFragment = new RandomFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment, randomFragment);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_other:
                    textView = (TextView)findViewById(R.id.title);
                    textView.setText("HIMASIF MOBILE");
                    OtherFragment otherFragment = new OtherFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragment, otherFragment);
                    fragmentTransaction3.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (RelativeLayout) findViewById(R.id.layout);
        fragment = (RelativeLayout) findViewById(R.id.fragment);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fragment.setAnimation(frombottom);
        textView = (TextView)findViewById(R.id.title);
        textView.setText("HIMASIF TODAY");
        HomeFragment homeFragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, homeFragment);
        fragmentTransaction.commit();
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

    }

}
