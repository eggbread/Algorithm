cmake_minimum_required(VERSION 3.0)
project(algorithms)

add_compile_options(-Wall -Wextra -Werror -Wpedantic)

set( CMAKE_BUILD_TYPE Debug )

add_subdirectory(algorithms)
add_subdirectory(test)
