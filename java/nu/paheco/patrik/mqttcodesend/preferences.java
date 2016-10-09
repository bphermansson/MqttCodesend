package nu.paheco.patrik.mqttcodesend;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by patrik on 9/27/16.
 */

public class preferences extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("In preferences.java","Show prefs");

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenceExampelFragment())
                .commit();
    }
}