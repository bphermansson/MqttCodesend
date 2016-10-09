package nu.paheco.patrik.mqttcodesend;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.widget.TextView;

/**
 * Created by patrik on 10/8/16.
 */

public class PreferenceExampelFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferenceManager().getSharedPreferences();
        //onSharedPreferenceChanged(prefs, STR_1);
        //prefs.registerOnSharedPreferenceChangeListener(this);

    }

}
