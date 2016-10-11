package nu.paheco.patrik.mqttcodesend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.provider.Settings;
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

        // Set button labels from stored settings
        btnLabels();

        //Button btn1=(Button)findViewById(R.id.btn1on);



    }

    public void btnLabels() {
        // Set button labels from stored settings
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
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

        Button btn1on=(Button) findViewById(R.id.btn1on);
        Button btn2on=(Button) findViewById(R.id.btn2on);
        Button btn3on=(Button) findViewById(R.id.btn3on);
        Button btn4on=(Button) findViewById(R.id.btn4on);
        Button btn5on=(Button) findViewById(R.id.btn5on);
        Button btn1off=(Button) findViewById(R.id.btn1off);
        Button btn2off=(Button) findViewById(R.id.btn2off);
        Button btn3off=(Button) findViewById(R.id.btn3off);
        Button btn4off=(Button) findViewById(R.id.btn4off);
        Button btn5off=(Button) findViewById(R.id.btn5off);

        // Set text
        edtext1.setText(text1);
        edtext2.setText(text2);
        edtext3.setText(text3);
        edtext4.setText(text4);
        edtext5.setText(text5);

        if (text1.equals("N/A")) {   // Not set
            btn1on.setEnabled(false);
            btn1off.setEnabled(false);
        }
        if (text2.equals("N/A")) {   // Not set
            btn2on.setEnabled(false);
            btn2off.setEnabled(false);
        }
        if (text3.equals("N/A")) {   // Not set
            btn3on.setEnabled(false);
            btn3off.setEnabled(false);
        }
        if (text4.equals("N/A")) {   // Not set
            btn4on.setEnabled(false);
            btn4off.setEnabled(false);
        }
        if (text5.equals("N/A")) {   // Not set
            btn5on.setEnabled(false);
            btn5off.setEnabled(false);
        }
        // Color the buttons
        edtext1.setBackgroundColor(0xE1BEE7);
        edtext2.setBackgroundColor(0xF3E5F5);
        edtext3.setBackgroundColor(0xE1BEE7);
        edtext4.setBackgroundColor(0xF3E5F5);
        edtext5.setBackgroundColor(0xE1BEE7);

    }

    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
        Log.d("In onRestart: ", "Oh well");
        // Update button lables after settings change
        btnLabels();
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
        //String mqtt_topic = sharedPref.getString("mqtt_topic", "");

        //System.out.println(view.getId());
        Log.d("mqttip",mqttip);
        //Log.d("mqtt_topic",mqtt_topic);

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

        String topic1 = sharedPref.getString("topic1", "");
        String topic2 = sharedPref.getString("topic2", "");
        String topic3 = sharedPref.getString("topic3", "");
        String topic4 = sharedPref.getString("topic4", "");
        String topic5 = sharedPref.getString("topic5", "");

        Log.d("In btnClick: ", topic1);

        switch (view.getId()) {
            case R.id.btn1on:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic1, code1on);
                break;
            case R.id.btn1off:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic1, code1off);
                break;
            case R.id.btn2on:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic2, code2on);
                break;
            case R.id.btn2off:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic2, code2off);
                break;
            case R.id.btn3on:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic3, code3on);
                break;
            case R.id.btn3off:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic3, code3off);
                break;
            case R.id.btn4on:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic4, code4on);
                break;
            case R.id.btn4off:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic4, code4off);
                break;
            case R.id.btn5on:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic5, code5on);
                break;
            case R.id.btn5off:
                MqttPublishSubscribeSample.main(mContext, mqttip, topic5, code5off);
                break;
        }
    }


}
