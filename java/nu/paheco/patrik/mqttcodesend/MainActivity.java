package nu.paheco.patrik.mqttcodesend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("codesend","oncreate");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String mqttip = sharedPref.getString("mqttip", "");
        Log.d("pref:", mqttip);
        String topic = sharedPref.getString("topic", "");
        Log.d("pref:", topic);

        Button btn1=(Button)findViewById(R.id.btn1on);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("Menu: ", "Create menu");
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.settings:
                startActivity(new Intent(this, preferences.class));
        }
        return super.onOptionsItemSelected(item);
    }


    public void btnClick(View view) {
        Log.d("codesend","btnClick");

        System.out.println(view.getId());
        String mqttip = getPreferences(MODE_PRIVATE).getString("mqttip", "");
        Log.d("mqttip",mqttip);


        switch (view.getId()) {
            case R.id.btn1on:
                MqttPublishSubscribeSample.main(mqttip, "1052693");
                break;
            case R.id.btn1off:
                MqttPublishSubscribeSample.main(mqttip, "1052692");
                break;
        }
    }


}
