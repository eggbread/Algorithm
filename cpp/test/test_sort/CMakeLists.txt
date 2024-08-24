# <legalese>


# </legalese>

set( target test_sort )

set(
   headers
)

set(
   sources
   test_sort.cc
)
set(
   OUTPUT_DIR
   ${PROJECT_BINARY_DIR}
)

message(${PROJECT_BINARY_DIR})

add_executable( ${target} ${sources} ${headers} )

target_link_libraries(
   ${target}
   sort
   gtest
   gtest_main
   pthread
)

set_target_properties(
   ${target}
   PROPERTIES
   LINKER_LANGUAGE
   CXX
   RUNTIME_OUTPUT_DIRECTORY
   ${OUTPUT_DIR}
)

# set(COVERIAGE_DIR ${PROJECT_BINARY_DIR}/coverage)
# add_custom_target(
#    coverage
#    COMMAND mkdir -p ${COVERIAGE_DIR}
#    COMMAND lcov --directory ${PROJECT_BINARY_DIR} --zerocounters
#    COMMAND lcov --capture --initial --directory ${PROJECT_BINARY_DIR} --output-file ${COVERIAGE_DIR}/coverage.info
#    COMMAND ${target}
#    COMMAND lcov --no-checksum --directory ${PROJECT_BINARY_DIR} --capture --output-file ${COVERIAGE_DIR}/coverage.info
#    COMMAND lcov --remove ${COVERIAGE_DIR}/coverage.info '/usr/*' --output-file ${COVERIAGE_DIR}/coverage.info
#    COMMAND genhtml ${COVERIAGE_DIR}/coverage.info --output-directory ${COVERIAGE_DIR}
#    WORKING_DIRECTORY ${PROJECT_BINARY_DIR}
# )