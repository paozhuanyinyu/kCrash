package com.paozhuanyinyu.kcrash;

public class NativeCrashTest {
    static {
        System.loadLibrary("demo");
    }
    public static void testNativeCrash(){
        nativeCrashTest();
    }
    private static native void nativeCrashTest();
}
