package com.example.FitnessTracker;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

/**
 * Created by Eman on 04/09/2015.
 */
public class WeightConverter extends Activity {
    private EditText weightmeasure, poundsmeasure;
    private TextView results1, results2;

    private static RadioGroup radio_g;
    private static Button gobutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weightconvert);
        initiatesetup();

            }

     public void initiatesetup() {
         radio_g = (RadioGroup) findViewById(R.id.selector);
         gobutton = (Button) findViewById(R.id.gobutton);

         gobutton.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         int selected_id = radio_g.getCheckedRadioButtonId();
                         System.out.println(selected_id);
                         switch (selected_id) {
                             case 2131099694: //change this into a final id
                                 kgtopounds();
                
                                 break;
                             case 2131099695: //change this into a final id
                                 poundstokg();
                                
                                 break;
                         }
                     }

                 });
     }


    public void kgtopounds() {
        Dialog dialog = new Dialog(WeightConverter.this);
        dialog.setContentView(R.layout.kgtopounds);
        results1 = (TextView) dialog.findViewById(R.id.result1);
        weightmeasure = (EditText) findViewById(R.id.weightedit);
        String stringkg = weightmeasure.getText().toString();
        double kg = Double.parseDouble(stringkg);
        double lbs = (double)Math.round(kg * 2.2046*100)/100;
        String stringlbs = Double.toString(lbs);
        results1.setText(stringlbs);
        dialog.show();

    }

    public void poundstokg() {
        Dialog dialog = new Dialog(WeightConverter.this);
        dialog.setContentView(R.layout.poundstokg);
        results2 = (TextView) dialog.findViewById(R.id.result2);
        poundsmeasure = (EditText) findViewById(R.id.weightedit);
        String stringlbs = poundsmeasure.getText().toString();
        double lbs = Double.parseDouble(stringlbs);
        double kg = (double)Math.round(lbs / 2.2046*100)/100;
        String stringkg = Double.toString(kg);
        results2.setText(stringkg);
        dialog.show();
    }
}



