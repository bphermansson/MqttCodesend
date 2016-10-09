package nu.paheco.patrik.mqttcodesend;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by patrik on 10/9/16.
 */

public class cscodes extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cscodes);

        // Show text
        TextView info = (TextView) findViewById(R.id.cscodes_text);
        String csinfo = getString(R.string.csinfo);
        info.setText(csinfo);
    }
}
