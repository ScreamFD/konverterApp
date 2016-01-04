package de.lamber.sascha.konverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public void convert(View view){

        String inputString = input.getText().toString();
        Double inputDouble = Double.parseDouble(inputString);

        Double result;

        switch (view.getId()){
            case R.id.usdToEur:
                result = usdToEur(inputDouble);
                showResult(result, "€");
                break;

            case R.id.eurToUsd:
                result = eurToUsd(inputDouble);
                showResult(result, "$");
                break;

            case R.id.inchToCm:
                result = inchToCm(inputDouble);
                showResult(result, "cm");
                break;

            case R.id.cmToInch:
                result = cmToInch(inputDouble);
                showResult(result, "\"");
                break;
        }
    }

    protected Double usdToEur(Double input){

        return  input / 1.13;
    }

    protected Double eurToUsd(Double input){

        return  input * 1.13;
    }

    protected Double inchToCm(Double input){

        return  input * 2.54;
    }

    protected Double cmToInch(Double input){

        return  input / 2.54;
    }

    protected void showResult(Double result, String targetUnit){

        BigDecimal formatedResult = new BigDecimal(result);
        formatedResult = formatedResult.setScale(2, RoundingMode.HALF_UP);

        String resultString = "Ergebnis: " + formatedResult + targetUnit;

        statusText.setText(resultString);
        statusText.setVisibility(View.VISIBLE);
    }
}
