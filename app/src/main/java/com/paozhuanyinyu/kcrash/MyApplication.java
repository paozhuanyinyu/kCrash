package com.paozhuanyinyu.kcrash;

import android.app.Application;

import com.paozhuanyinyu.crash.CrashManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashManager.getInstance().init(this);
    }
}
