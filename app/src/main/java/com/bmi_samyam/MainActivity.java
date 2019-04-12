package com.bmi_samyam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    TextView tvBmis;
    Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvBmis = findViewById(R.id.tvBmis);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height, weight, bmi;
                height= Double.parseDouble(etHeight.getText().toString());

                weight = Double.parseDouble(etWeight.getText().toString());

                bmi Calculator= new bmi(height, weight);
                bmi= Calculator.Bmi();
                tvBmis.setText(Double.toString(bmi));

                Toast.makeText( MainActivity.this, Calculator.calculator(), Toast.LENGTH_LONG).show();


                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCalculate.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);


            }
        });
    }
}
