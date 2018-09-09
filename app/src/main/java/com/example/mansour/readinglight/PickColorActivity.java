package com.example.mansour.readinglight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class PickColorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_color);
        Bundle mBundle = getIntent().getExtras();
        int mColor = mBundle.getInt(MainActivity.TAG);

        RelativeLayout coloredLayout = (RelativeLayout) findViewById(R.id.coloredLayout);
        coloredLayout.setBackgroundColor(mColor);

    }
}
