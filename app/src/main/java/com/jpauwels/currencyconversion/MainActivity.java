package com.jpauwels.currencyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //declare variables
    double conversionRate = 6.63;
    double amountEntered = 0.0;
    double convertedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //declare connections to interface components
        final EditText amount = (EditText)findViewById(R.id.txtAmount);
        final RadioButton usToCn = (RadioButton)findViewById(R.id.radUsToCn);
        final RadioButton cnToUs = (RadioButton)findViewById(R.id.radCnToUs);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountEntered = Double.parseDouble(amount.getText().toString());
                DecimalFormat hundredth = new DecimalFormat("#.##");
                if (usToCn.isChecked()) {
                    if (amountEntered < 10001) {
                        convertedAmount = amountEntered * conversionRate;
                        result.setText(hundredth.format(convertedAmount) + " Chinese Yuan");
                    } else {
                        Toast.makeText(MainActivity.this, "Amount must be 10,000 or less.",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if (cnToUs.isChecked()) {
                    if (amountEntered < 10001) {
                        convertedAmount = amountEntered / conversionRate;
                        result.setText(hundredth.format(convertedAmount) + " US Dollars");
                    } else {
                        Toast.makeText(MainActivity.this, "Amount must be 10,000 or less.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
    });
}
}