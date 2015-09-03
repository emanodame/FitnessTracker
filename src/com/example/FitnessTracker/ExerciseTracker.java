package com.example.FitnessTracker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

/**
 * Created by Eman on 8/16/2015.
 */
public class ExerciseTracker extends Activity {
    ViewPager viewpager;
    CustomSwipeAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker);
        viewpager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewpager.setAdapter(adapter);
        }
        }