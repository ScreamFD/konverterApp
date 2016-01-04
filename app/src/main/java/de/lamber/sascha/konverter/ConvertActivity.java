package de.lamber.sascha.konverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {

    Button usdToEurButton;
    Button eurToUsdButton;
    Button inchToCmButton;
    Button cmToInchButton;

    EditText input;
    TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        usdToEurButton = (Button) findViewById(R.id.usdToEur);
        eurToUsdButton = (Button) findViewById(R.id.eurToUsd);
        inchToCmButton = (Button) findViewById(R.id.inchToCm);
        cmToInchButton = (Button) findViewById(R.id.cmToInch);

        input = (EditText) findViewById(R.id.input);
        statusText = (TextView) findViewById(R.id.resultText);
    }
}
