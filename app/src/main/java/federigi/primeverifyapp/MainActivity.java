package federigi.primeverifyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import federigi.primeverifyapp.engine.PrimeUtil;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    private EditText inputNumber;
    private TextView isPrimeTextView;
    private TextView notPrimeTextView;
    private TextView nullNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = (EditText) findViewById(R.id.inputNumber);
        isPrimeTextView = (TextView) findViewById(R.id.is_prime_number);
        notPrimeTextView = (TextView) findViewById(R.id.not_prime_number);
        nullNumberTextView = (TextView) findViewById(R.id.null_number);

        inputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                isPrimeTextView.setVisibility(View.GONE);
                notPrimeTextView.setVisibility(View.GONE);
                nullNumberTextView.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (inputNumber == null)
        Log.e(TAG, "InputNumber is null");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about) {

            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void verifyNumber(View view) {
        String number = inputNumber.getText().toString();
        if (number == null || number.length() == 0) {
            nullNumberTextView.setVisibility(View.VISIBLE);
        } else {
            nullNumberTextView.setVisibility(View.GONE);
            boolean isPrime = PrimeUtil.isCircularPrime(Integer.valueOf(number));
            isPrimeTextView.setVisibility(isPrime ? View.VISIBLE : View.GONE);
            notPrimeTextView.setVisibility(!isPrime ? View.VISIBLE : View.GONE);
        }
    }


}
