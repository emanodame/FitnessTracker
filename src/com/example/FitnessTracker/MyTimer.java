package com.example.FitnessTracker;

import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class  MyTimer extends Activity {
//
    long initialtime=60000;
    Button btnStart, btnStop; //Initialising buttons for my Start/Pause buttons.
    TextView textViewTime; //This is the view for the actual countdown.


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        textViewTime = (TextView) findViewById(R.id.textviewTime);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setVisibility(View.INVISIBLE);


        final CounterClass timer = new CounterClass(initialtime,1000); //Set at 60000 which is one minute. 1000ms decremenets every second.
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                btnStart.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.VISIBLE);
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                btnStop.setVisibility(View.INVISIBLE);
                btnStart.setVisibility(View.VISIBLE);
            }
        });

    }

    public class CounterClass extends CountDownTimer{
        public CounterClass(long millisinFuture, long countDownInterval){
            super(millisinFuture,countDownInterval);
        }

        public void onTick(long millisUntilFinished){
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            //Vibration set when countdown finish.
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(2500);
            btnStop.setVisibility(View.INVISIBLE);
            btnStart.setVisibility(View.VISIBLE);
            textViewTime.setText("00:01:00");
        }
    }


}

