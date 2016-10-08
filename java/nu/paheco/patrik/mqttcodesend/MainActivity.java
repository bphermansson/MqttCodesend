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
import android.widget.EditText;
import android.widget.TextView;

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

        // Get button labels from stored preferences
        String text1 = sharedPref.getString("text1", "N/A");
        String text2 = sharedPref.getString("text2", "N/A");
        String text3 = sharedPref.getString("text3", "N/A");
        String text4 = sharedPref.getString("text4", "N/A");
        String text5 = sharedPref.getString("text5", "N/A");
        // Get gui views
        TextView edtext1=(TextView) findViewById(R.id.text1);
        TextView edtext2=(TextView) findViewById(R.id.text2);
        TextView edtext3=(TextView) findViewById(R.id.text3);
        TextView edtext4=(TextView) findViewById(R.id.text4);
        TextView edtext5=(TextView) findViewById(R.id.text5);
        // Set text
        edtext1.setText(text1);
        edtext2.setText(text2);
        edtext3.setText(text3);
        edtext4.setText(text4);
        edtext5.setText(text5);


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

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String mqttip = sharedPref.getString("mqttip", "");

        System.out.println(view.getId());
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
