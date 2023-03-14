package eu.tutorials.calculatorjavaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText numerator;
    private EditText divisor;
    private TextView result;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        df = new DecimalFormat("0.00");

        numerator = findViewById(R.id.inputNumerator);
        divisor = findViewById(R.id.inputDivisor);
        result = findViewById(R.id.resultView);
    }

    public void sum(View view){
        if(numerator.getText().length()==0 || divisor.getText().length()==0)
            return;

        int a = Integer.valueOf(String.valueOf(numerator.getText()));
        int b = Integer.valueOf(String.valueOf(divisor.getText()));

        result.setText(String.valueOf(a+b));
    }
    public void minus(View view){
        if(numerator.getText().length()==0 || divisor.getText().length()==0)
            return;

        int a = Integer.valueOf(String.valueOf(numerator.getText()));
        int b = Integer.valueOf(String.valueOf(divisor.getText()));

        result.setText(String.valueOf(a-b));
    }
    public void multiply(View view){
        if(numerator.getText().length()==0 || divisor.getText().length()==0)
            return;

        int a = Integer.valueOf(String.valueOf(numerator.getText()));
        int b = Integer.valueOf(String.valueOf(divisor.getText()));

        result.setText(String.valueOf(a*b));
    }
    public void divide(View view){
        if(numerator.getText().length()==0 || divisor.getText().length()==0 || Integer.valueOf(String.valueOf(divisor.getText())) == 0)
            return;

        int a = Integer.valueOf(String.valueOf(numerator.getText()));
        int b = Integer.valueOf(String.valueOf(divisor.getText()));

        // onko tasaluku
        if(a % b == 0){
            result.setText(String.valueOf(a/b));
        } else { // liukuluku kahden desimaalin tarkkuudella, koska lastenlaskin
            result.setText(String.valueOf(df.format((double)a/b)));
        }
    }
}