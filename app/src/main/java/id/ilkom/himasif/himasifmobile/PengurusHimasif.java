package id.ilkom.himasif.himasifmobile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.example.brianr.himasifmobile.R;

public class PengurusHimasif extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    RelativeLayout layout;
    private WebView isi;
    private  ProgressDialog pDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengurus_himasif);
        layout = (RelativeLayout)findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        isi=(WebView)findViewById(R.id.webview);

      /*  try {
            pDialog = new ProgressDialog(this);
            // Showing progress dialog before making http request
            pDialog.setMessage("Loading...");
            pDialog.show();

            pDialog.dismiss();


        }
        catch (Exception e){

        }*/


        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.show();

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progress.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3500);


        progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                isi.loadDataWithBaseURL(null,"<style>img{display: inline;height: auto;max-width: 100%;}</style>" +
                        "<img src=\"http://himasif.ilkom.unej.ac.id/wp-content/uploads/2018/01/pengurusBaru.png\">","text/html","UTF-8",null);

            }
        });



    }
}
