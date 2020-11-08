cmake_minimum_required(VERSION 3.4.1)

add_library(demo SHARED demo.cpp)

target_link_libraries(demo log)