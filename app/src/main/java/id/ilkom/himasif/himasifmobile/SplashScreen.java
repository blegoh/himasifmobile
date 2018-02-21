package id.ilkom.himasif.himasifmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;


public class SplashScreen extends Activity {
    private static int splashInterval = 2000;
    String versionName = BuildConfig.VERSION_NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView version = (TextView)findViewById(R.id.version);
        version.setText("Version "+versionName);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                this.finish();
            }
            private void finish(){

            }
        },splashInterval);

    }
}
