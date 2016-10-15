package nu.paheco.patrik.mqttcodesend;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by patrik on 10/15/16.
 */

public class help extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        // Show text
        TextView header = (TextView) findViewById(R.id.help_header);
        String helpheader = getString(R.string.help_header);
        header.setText(helpheader);

        TextView info = (TextView) findViewById(R.id.help_text);
        String help = getString(R.string.help);
        info.setText(help);
    }
}
