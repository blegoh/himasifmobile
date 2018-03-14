package id.ilkom.himasif.himasifmobile;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;

import me.anwarshahriar.calligrapher.Calligrapher;


public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    Animation frombottom;
    RelativeLayout layout, fragment;
    TextView textView;
    Fragment home, random, other, nim;

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

            if (fragment != null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return fragment != null;
        }
    };

    @SuppressLint("ResourceAsColor")
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
//        animationDrawable = (AnimationDrawable) layout.getBackground();
//        animationDrawable.setEnterFadeDuration(4500);
//        animationDrawable.setExitFadeDuration(4500);
//        animationDrawable.start();
        if (PreferencesApp.isFirstLaunch()) {

            final TapTargetSequence sequence = new TapTargetSequence(this)
                    .targets(
                            TapTarget.forView(findViewById(R.id.navigation_home), "HIMASIF TODAY", "Dapatkan semua berita tentang kampus, event, \nalumni, dan teknologi dunia").outerCircleColor(R.color.colorPrimary).id(1),
                            TapTarget.forView(findViewById(R.id.navigation_nimchecker), "NIMCHECKER", "Anda dapat dengan mudah menemukan\nNama dan NIM teman anda").outerCircleColor(R.color.colorPrimary).id(2),
                            TapTarget.forView(findViewById(R.id.navigation_random), "RANDOM", "Permudah diri dan teman anda dalam menentukan\nkelompok berdasarkan jumlah mahasiswa,\nkelompok dan anggota").outerCircleColor(R.color.colorPrimary).id(3),
                            TapTarget.forView(findViewById(R.id.navigation_other), "OTHER", "Temukan apa saja visi misi, tentang kami, pengurus HIMASIF,\n dan anda juga dapat menyampaikan kritik dan saran disini").outerCircleColor(R.color.colorPrimary).id(4))
                    .listener(new TapTargetSequence.Listener() {
                        @Override
                        public void onSequenceFinish() {
                            PreferencesApp.hasFirstLaunch();
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                            Log.d("Tap TargetView", "Clicked on" + lastTarget.id());
                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                            final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Uh oh")
                                    .setMessage("You canceled the sequence")
                                    .setPositiveButton("Oops", null).show();
                            TapTargetView.showFor(dialog,
                                    TapTarget.forView(dialog.getButton(DialogInterface.BUTTON_POSITIVE), "Uh oh!", "You canceled the sequence at step " + lastTarget.id())
                                            .cancelable(false)
                                            .tintTarget(false), new TapTargetView.Listener() {
                                        @Override
                                        public void onTargetClick(TapTargetView view) {
                                            super.onTargetClick(view);
                                            dialog.dismiss();
                                        }
                                    });
                        }
                    });
            sequence.start();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

    }


}
