package id.ilkom.himasif.himasifmobile;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;



import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    Animation frombottom;
    RelativeLayout layout, fragment;
    TextView textView;

    Fragment home,random,other,nim;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    textView = (TextView) findViewById(R.id.title);
                    textView.setText("HIMASIF TODAY");

                    fragment = home;
                    if (fragment == null) {
                        home = new HomeFragment();
                    }
                    break;
                case R.id.navigation_nimchecker:
                    textView = (TextView) findViewById(R.id.title);
                    textView.setText("NIMCHECKER");

                    fragment = nim;
                    if (fragment == null) {
                        nim = new NimcheckerFragment();
                        fragment = nim;
                    }
                    break;
                case R.id.navigation_random:
                    textView = (TextView) findViewById(R.id.title);
                    textView.setText("RANDOM");

                    fragment = random;
                    if (fragment == null) {
                        random = new RandomFragment();
                        fragment = random;
                    }
                    break;
                case R.id.navigation_other:
                    textView = (TextView) findViewById(R.id.title);
                    textView.setText("HIMASIF MOBILE");

                    fragment = other;
                    if (fragment == null) {
                        other = new OtherFragment();
                        fragment = other;
                    }
                    break;

            }

            if(fragment!=null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
            return fragment!=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/Roboto-Regular.ttf", true);
        layout = (RelativeLayout) findViewById(R.id.layout);
        fragment = (RelativeLayout) findViewById(R.id.fragment);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fragment.setAnimation(frombottom);
        textView = (TextView) findViewById(R.id.title);
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
