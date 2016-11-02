package nu.paheco.patrik.mqttcodesend;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by patrik on 9/27/16.
 */

public class preferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Log.d("In preferences.java","Show prefs");

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenceExampelFragment())
                .commit();

    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
                                          String key) {
        Toast.makeText(getApplicationContext(),
                "Your Message", Toast.LENGTH_LONG).show();
    }
}