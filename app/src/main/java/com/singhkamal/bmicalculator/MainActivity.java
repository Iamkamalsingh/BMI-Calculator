package com.singhkamal.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextWt, editTextHtFt, editTextHtIn;
        Button button;
        TextView textResult;
        ConstraintLayout llMain;

        editTextWt = findViewById(R.id.editTextWt);
        editTextHtIn = findViewById(R.id.editTextHtIn);
        editTextHtFt = findViewById(R.id.editTextHtFt);
        button = findViewById(R.id.button);
        textResult = findViewById(R.id.textResult);
        llMain = findViewById(R.id.llMain);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        TextView textViewBMI = findViewById(R.id.textViewBMI);


        // Initially check the male RadioButton
        radioGroupGender.check(R.id.radioButtonMale);


        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int backgroundColor;
                if (checkedId == R.id.radioButtonMale) {
                    backgroundColor = getResources().getColor(R.color.maleBackgroundColor);
                } else {
                    backgroundColor = getResources().getColor(R.color.femaleBackgroundColor);
                }
                llMain.setBackgroundColor(backgroundColor);
            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt( editTextWt.getText().toString() );
                int ft = Integer.parseInt( editTextHtFt.getText().toString() );
                int cm = Integer.parseInt( editTextHtIn.getText().toString() );

                int totalIn = (ft * 12) + cm;
                double totalCm = totalIn * 2.54;
                double totalM = totalCm / 100;

                double bmi = wt / (totalM * totalM);


                textViewBMI.setText(getString(R.string.your_bmi_is) + " " + String.format("%.2f",bmi));

                if (bmi > 25) {
                    textResult.setText(R.string.you_are_overweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                } else if (bmi < 18) {
                    textResult.setText(R.string.you_are_underweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                } else {
                    textResult.setText(R.string.you_are_normal);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });

        }}
