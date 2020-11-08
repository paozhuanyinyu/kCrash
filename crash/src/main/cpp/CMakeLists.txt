cmake_minimum_required(VERSION 3.4.1)


include_directories(breakpad/src breakpad/src/common/android/include)

#第一个参数指定库的名字(lib+name);第二个参数指定是静态库(static->.a文件)还是动态库(SHARED->.so文件);第三个参数指定编译的源码文件
add_library(kcrash SHARED kcrash.cpp)

add_subdirectory(breakpad)

# 链接ndk中的log库
target_link_libraries(kcrash breakpad log)

