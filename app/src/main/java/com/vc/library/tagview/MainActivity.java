package com.vc.library.tagview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vc.view.colortagview.ColorTagView;

public class MainActivity extends AppCompatActivity {

    private ColorTagView mColorTagView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mColorTagView = (ColorTagView) findViewById(R.id.tagview);

        mColorTagView.setTagRadius(15);

        mColorTagView.setTagBgColor(Color.GREEN);
        mColorTagView.setTagBgStrokeWidth(10);
        mColorTagView.setTagBgStyle(ColorTagView.STROKE);

    }



}
