package com.paozhuanyinyu.crash;

import android.content.Context;
import java.io.File;

public class CrashManager {
    static {
        System.loadLibrary("kcrash");
    }

    private static CrashManager instance;
    public static CrashManager getInstance() {
        if(instance == null){
            synchronized (CrashManager.class){
                if(instance == null){
                    instance = new CrashManager();
                }
            }
        }
        return instance;
    }

    private CrashManager(){

    }

    public void init(Context context){
        Context applicationContext = context.getApplicationContext();
        CrashHandler.getInstance().init(applicationContext);
        File dir = new File(applicationContext.getExternalCacheDir(),"native_crash");
        if(!dir.exists()){
            dir.mkdirs();
        }
        initNativeCollectCrash(dir.getAbsolutePath());
    }

    private static native void initNativeCollectCrash(String filePath);
}
