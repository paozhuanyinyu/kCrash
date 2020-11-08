#include <jni.h>
#include <android/log.h>
#include <client/linux/handler/minidump_descriptor.h>
#include <client/linux/handler/exception_handler.h>

//
// Created by 喻凯 on 2020/11/8.
//


bool DumpCallback(const google_breakpad::MinidumpDescriptor& descriptor,
                  void* context,
                  bool succeeded) {
    __android_log_print(ANDROID_LOG_ERROR,"native","crash callback");
    return false;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_paozhuanyinyu_crash_CrashManager_initNativeCollectCrash(JNIEnv* env,jclass clazz, jstring file_path) {
    const char *path = env->GetStringUTFChars(file_path,0);
    __android_log_print(ANDROID_LOG_INFO,"native","file path: %s",path);

    google_breakpad::MinidumpDescriptor descriptor(path);
    static google_breakpad::ExceptionHandler eh(descriptor, NULL, DumpCallback,
                                         NULL, true, -1);

    env->ReleaseStringUTFChars(file_path,path);
}