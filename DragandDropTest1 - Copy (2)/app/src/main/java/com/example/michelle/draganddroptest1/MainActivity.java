package com.example.michelle.draganddroptest1;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textApple).setOnLongClickListener(longListen);
        findViewById(R.id.textPear).setOnLongClickListener(longListen);
        findViewById(R.id.textdragon).setOnLongClickListener(longListen);
        findViewById(R.id.textOrange).setOnLongClickListener(longListen);
    }

    /*@Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }*/

    View.OnLongClickListener longListen = new View.OnLongClickListener()
    {

        @Override
        public boolean onLongClick(View v)
        {
            ClipData data = ClipData.newPlainText("","");
            v.startDrag(data,shadowBuilder, myLocalState, 0);
            return false;
        }
    };

    private class DragShadow extends View.DragShadowBuilder
    {
        ColorDrawable greyBox;
        public DragShadow(View view) {
            super(view);
            greyBox = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onDrawShadow (Canvas canvas) {
            super.onDrawShadow(canvas);
        }

        @Override
        public void onProvideShadowMetrics (Point shadowSize, Point shadowTouchPoint){
            View v = getView();

            int height = (int)v.getHeight()/2;
            int width = (int)v.getWidth()/2;

            greyBox.setBounds(0, 0, width, height);

            shadowSize.set(width, height);
        }
    }
}
