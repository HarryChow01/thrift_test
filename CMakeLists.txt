cmake_minimum_required(VERSION 2.7)
project(thrift_cpp_test)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")


include_directories("${CMAKE_CURRENT_SOURCE_DIR}"
                    "${CMAKE_CURRENT_SOURCE_DIR}/src"
                    "${CMAKE_CURRENT_SOURCE_DIR}/gen-cpp"
                    "${CMAKE_CURRENT_SOURCE_DIR}/../common/libevent-2.1.8-stable/include"
                    "${CMAKE_CURRENT_SOURCE_DIR}/../common/thrift-0.10.0/include/"
                    )
link_directories("${CMAKE_CURRENT_SOURCE_DIR}/../common/thrift-0.10.0/lib")
link_directories("${CMAKE_CURRENT_SOURCE_DIR}/../common/libevent-2.1.8-stable/lib")

add_executable(student_client student_client.cpp gen-cpp/student_types.cpp gen-cpp/StudentService.cpp)
add_executable(student_server_simple student_server_simple.cpp gen-cpp/student_types.cpp gen-cpp/StudentService.cpp)
add_executable(student_server_complex student_server_complex.cpp gen-cpp/student_types.cpp gen-cpp/StudentService.cpp)
target_link_libraries(student_client thrift pthread)
target_link_libraries(student_server_simple thrift pthread)
# thriftnb库一定要在thrift前面，否则会坑爹
target_link_libraries(student_server_complex thriftnb thrift event pthread)


