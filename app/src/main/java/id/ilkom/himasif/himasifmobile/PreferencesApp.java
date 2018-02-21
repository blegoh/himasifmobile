package id.ilkom.himasif.himasifmobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Brian R on 20/02/2018.
 */

public class PreferencesApp {
    private static PreferencesApp preferencesApp;
    private static SharedPreferences sharedPreferences;

    private PreferencesApp(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void initPreferences(Context context) {
        if (preferencesApp == null) {
            preferencesApp = new PreferencesApp(context);
        }
    }

    public static boolean isFirstLaunch() {
        return sharedPreferences.getBoolean("LAUNCH", true);
    }

    public static void hasFirstLaunch() {
        sharedPreferences.edit().putBoolean("LAUNCH", false).apply();
    }
}
