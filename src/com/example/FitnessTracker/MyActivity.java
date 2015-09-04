package com.example.FitnessTracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void exctrackbutton(View v){
        Intent exercisetrack = new Intent(this, ExerciseTracker.class);
        startActivity(exercisetrack);
    }


    public void timerbutton(View v){
        Intent timer = new Intent(this, MyTimer.class);
        startActivity(timer);

    }
    public void weighttrackbutton(View v){
        Intent weighttrack = new Intent(this,WeightTracker.class);
        startActivity(weighttrack);
    }



}

