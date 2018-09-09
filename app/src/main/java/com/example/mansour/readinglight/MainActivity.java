package com.example.mansour.readinglight;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mBtnPickColor;
    int mDefaultColor;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(this, PickColorActivity.class);
        mDefaultColor = Color.WHITE;
        mBtnPickColor = (Button) findViewById(R.id.btnPickColor);
        mBtnPickColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
    }


    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(MainActivity.this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(MainActivity.this, "Canceled!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                mIntent.putExtra(TAG, mDefaultColor);
                startActivity(mIntent);
            }
        });
        colorPicker.show();
    }
}

