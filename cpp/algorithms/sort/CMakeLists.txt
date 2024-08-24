set( target sort )

file(GLOB_RECURSE CPP_ALGORITHMS_SORT_HEADERS "*.h")
file(GLOB_RECURSE CPP_ALGORITHMS_SORT_SOURCES "*.cc")

add_library( 
    ${target} 
    ${CPP_ALGORITHMS_SORT_SOURCES} 
    ${CPP_ALGORITHMS_SORT_HEADERS} 
)

target_include_directories(
   ${target}
   PUBLIC
   ${CMAKE_CURRENT_SOURCE_DIR}
)

set_target_properties(
    ${target}
    PROPERTIES
    LINKER_LANGUAGE
    CXX
)