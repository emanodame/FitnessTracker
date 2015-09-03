package com.example.FitnessTracker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.chestpress,R.drawable.dips,R.drawable.chestpress,R.drawable.triceppulldown,R.drawable.machinechest,R.drawable.chestfly,R.drawable.pullups,R.drawable.hammercurls,R.drawable.deadlift,R.drawable.bcurl,R.drawable.squat,R.drawable.legpress,R.drawable.legextensions,R.drawable.legcurl,};
    private Context ctx; //Gets the context of a current state or application. Tells program what is going on somewhere else.
    private LayoutInflater layoutInflater;  //USed to instantiate layout XML files to View Objct.
    private String[] names = {"Dumbbell Press","Tricep Dips","Incline Dumbbell Press","Tricep Pulldowns","Machine Chest Press","Chest Fly","Pull Ups","Hammer Curls","Deadlifts","Bicep Curl","Squats","Leg Press","Leg Extension","Leg Curl"};
    public ImageView imageView;


    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==(LinearLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView) item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        textView.setText(names[position]);
        container.addView(item_view);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(position){
                 case 0:
                     Intent intent0 = new Intent(CustomSwipeAdapter.this.ctx, DumbbellPress.class);
                     CustomSwipeAdapter.this.ctx.startActivity(intent0);
                     break;
                 case 1:
                     Intent intent1 = new Intent(CustomSwipeAdapter.this.ctx, Dips.class);
                     CustomSwipeAdapter.this.ctx.startActivity(intent1);
                     break;
                 case 2:
                     Intent intent2 = new Intent(CustomSwipeAdapter.this.ctx, IDumbbellPress.class);
                     CustomSwipeAdapter.this.ctx.startActivity(intent2);
                     break;

                    case 3:
                        Intent intent3 = new Intent(CustomSwipeAdapter.this.ctx, TriPulldown.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(CustomSwipeAdapter.this.ctx, MChestPress.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(CustomSwipeAdapter.this.ctx, ChestFly.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(CustomSwipeAdapter.this.ctx, Pullups.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(CustomSwipeAdapter.this.ctx, Hammercurls.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(CustomSwipeAdapter.this.ctx, Deadlift.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(CustomSwipeAdapter.this.ctx, BCurl.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent9);
                        break;

                    case 10:
                        Intent intent10 = new Intent(CustomSwipeAdapter.this.ctx, Squats.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(CustomSwipeAdapter.this.ctx, LegPress.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12 = new Intent(CustomSwipeAdapter.this.ctx, LegExtension.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent12);
                        break;
                    case 13:
                        Intent intent13= new Intent(CustomSwipeAdapter.this.ctx, LegCurl.class);
                        CustomSwipeAdapter.this.ctx.startActivity(intent13
                        );
                        break;

             }
                }
        });

        return item_view;
    }

    @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }


}



















