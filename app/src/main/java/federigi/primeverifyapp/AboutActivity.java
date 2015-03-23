package federigi.primeverifyapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.widget.TextView;


public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String aboutTxt = getString(R.string.about_text);
        TextView aboutTextView = (TextView) findViewById(R.id.about_text);

        aboutTextView.setText(Html.fromHtml(aboutTxt));
    }

}
