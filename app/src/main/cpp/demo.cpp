#include "jni.h"
#include "android/log.h"


//
// Created by 喻凯 on 2020/11/8.
//

extern "C"
JNIEXPORT void JNICALL
Java_com_paozhuanyinyu_kcrash_NativeCrashTest_nativeCrashTest(JNIEnv *env, jclass clazz) {
    __android_log_print(ANDROID_LOG_INFO, "native", "test native crash");
    int *p = NULL;
    *p = 10;
}