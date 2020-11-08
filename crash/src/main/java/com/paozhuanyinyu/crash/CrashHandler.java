package com.paozhuanyinyu.crash;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CrashHandler implements Thread.UncaughtExceptionHandler{
    private static CrashHandler instance;
    private static Context mContext;
    private static Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    public static CrashHandler getInstance() {
        if(instance == null){
            synchronized (CrashHandler.class){
                if(instance == null){
                    instance = new CrashHandler();
                }
            }
        }
        return instance;
    }

    private CrashHandler(){

    }

    /**
     * 初始化方法
     * @param applicationContext
     */
    public void init(Context applicationContext){
        mContext = applicationContext;
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        File dir = new File(mContext.getExternalCacheDir(),"java_crash");
        if(!dir.exists()){
            dir.mkdirs();
        }

        long timeMillis = System.currentTimeMillis();
        File file = new File(dir, timeMillis + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("time: " + timeMillis);
            printWriter.println("thread: " + thread.getName());
            throwable.printStackTrace(printWriter);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(defaultUncaughtExceptionHandler != null){
                defaultUncaughtExceptionHandler.uncaughtException(thread,throwable);
            }
        }
    }
}
