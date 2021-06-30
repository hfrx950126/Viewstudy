package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("aaa","onCreate MainActivity2");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("aaa", "onStart() MainActivity2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("aaa", "onRestart MainActivity2");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aaa", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("aaa", "onnPause MainActivity2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("aaa", "onStop MainActivity2");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("aaa", "onDestroy MainActivity2");
    }
}