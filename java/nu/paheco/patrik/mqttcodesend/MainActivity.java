package nu.paheco.patrik.mqttcodesend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("codesend","oncreate");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String mqttip = sharedPref.getString("mqttip", "");
        Log.d("pref:", mqttip);

        String mqtt_topic = sharedPref.getString("mqtt_topic", "");
        Log.d("topic:", mqtt_topic);


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
        Log.d("id", String.valueOf(id));
        switch (id) {
            case R.id.settings:
                startActivity(new Intent(this, preferences.class));
                break;
            case R.id.cscodesinfo:
                startActivity(new Intent(this, cscodes.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnClick(View view) {
        Log.d("codesend","btnClick");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String mqttip = sharedPref.getString("mqttip", "");
        String mqtt_topic = sharedPref.getString("mqtt_topic", "");

        //System.out.println(view.getId());
        Log.d("mqttip",mqttip);
        Log.d("mqtt_topic",mqtt_topic);

        String code1on = sharedPref.getString("code1on", "");
        String code2on = sharedPref.getString("code2on", "");
        String code3on = sharedPref.getString("code3on", "");
        String code4on = sharedPref.getString("code4on", "");
        String code5on = sharedPref.getString("code5on", "");
        String code1off = sharedPref.getString("code1off", "");
        String code2off = sharedPref.getString("code2off", "");
        String code3off = sharedPref.getString("code3off", "");
        String code4off = sharedPref.getString("code4off", "");
        String code5off = sharedPref.getString("code5off", "");

        switch (view.getId()) {
            case R.id.btn1on:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code1on);
                break;
            case R.id.btn1off:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code1off);
                break;
            case R.id.btn2on:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code2on);
                break;
            case R.id.btn2off:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code2off);
                break;
            case R.id.btn3on:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code3on);
                break;
            case R.id.btn3off:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code3off);
                break;
            case R.id.btn4on:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code4on);
                break;
            case R.id.btn4off:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code4off);
                break;
            case R.id.btn5on:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code5on);
                break;
            case R.id.btn5off:
                MqttPublishSubscribeSample.main(mContext, mqttip, mqtt_topic, code5off);
                break;
        }
    }


}
