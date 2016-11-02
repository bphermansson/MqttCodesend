package nu.paheco.patrik.mqttcodesend;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
        @Override
        public void onResume() {
            super.onResume();


            addPreferencesFromResource(R.xml.preferences);

            // Find preferences and set their summaries to the current value
            String mqttip = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("mqttip", "");
            String mqttuser = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("mqttuser", "");
            String mqttpass = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("mqttpass", "");

            EditTextPreference Prefmqttip = (EditTextPreference)findPreference("mqttip");
            EditTextPreference Prefmqttuser = (EditTextPreference)findPreference("mqttuser");
            EditTextPreference Prefmqttpass = (EditTextPreference)findPreference("mqttpass");

            Prefmqttip.setSummary(mqttip);
            Prefmqttuser.setSummary(mqttuser);
            Prefmqttpass.setSummary(mqttpass);

            new SharedPreferences.OnSharedPreferenceChangeListener()
            {
                public void onSharedPreferenceChanged(SharedPreferences prefs, String key)
                {
                    Toast.makeText(getActivity(), "this is my Toast message!!! =)",
                            Toast.LENGTH_LONG).show();
                    Log.d("TAG","Setting change");
                }
            };

        }


    }
}
