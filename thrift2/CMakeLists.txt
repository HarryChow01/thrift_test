cmake_minimum_required(VERSION 3.2)
project(thrift2_test)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")


include_directories("${CMAKE_CURRENT_SOURCE_DIR}"
                    "${CMAKE_CURRENT_SOURCE_DIR}/src"
                    "${CMAKE_CURRENT_SOURCE_DIR}/gen-cpp"
                    )
# link_directories("${CMAKE_CURRENT_SOURCE_DIR}/../common/thrift-0.10.0/lib")

add_executable(test_map_client test_map_client.cpp gen-cpp/test_map_types.cpp gen-cpp/testMapService.cpp)
add_executable(test_map_server test_map_server.cpp gen-cpp/test_map_types.cpp gen-cpp/testMapService.cpp)
target_link_libraries(test_map_client thrift pthread)
# thriftnb库一定要在thrift前面，否则会坑爹
target_link_libraries(test_map_server thriftnb thrift event pthread)


