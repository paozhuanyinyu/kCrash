package com.paozhuanyinyu.kcrash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试Java崩溃
//        JavaCrashTest.testJavaCrash();
        //测试Native崩溃
        NativeCrashTest.testNativeCrash();
    }
}