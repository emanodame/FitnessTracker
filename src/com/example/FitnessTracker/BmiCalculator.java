package com.example.FitnessTracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculator extends Activity {
    private EditText bmiheight, bmiweight;
    private TextView textresult, numresult;
    private Button buttongo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmilayout);
        buttongo = (Button) findViewById(R.id.bmigo);


        buttongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmicalc();

            }
        });

    }


    public void bmicalc() {
        bmiheight = (EditText) findViewById(R.id.bmiheight);
        bmiweight = (EditText) findViewById(R.id.bmiweight);
        numresult = (TextView) findViewById(R.id.numresult);
        textresult = (TextView) findViewById(R.id.textresult);

        String stringheight = bmiheight.getText().toString();
        String stringweight = bmiweight.getText().toString();
        double height = Double.parseDouble(stringheight);
        double weight = Double.parseDouble(stringweight);

        double bmi = (double) Math.round(weight / ( Math.pow ( height, 2)) * 10 ) /10;
        String textbmi = Double.toString(bmi);
        numresult.setText(textbmi);

        if (bmi < 18.5) {
            textresult.setText("Underweight!");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            textresult.setText("Normal Weight");
        } else if (bmi <= 25.0 && bmi >= 29.9) {
            textresult.setText("Overweight");
        } else if (bmi <= 30.0 && bmi <= 34.9) {
            textresult.setText("Class 1 Obesity");
        } else if (bmi <= 35.0 && bmi <= 39.9) {
            textresult.setText("Class 2 Obesity");
        } else if (bmi >= 40.0) {
            textresult.setText("Damm Brah");
        }


    }
}


