#include <iostream>
#include "sort.h"
#include <algorithm>
#include "gtest/gtest.h"
#include <random>

#define NUM_TESTS 10000

std::random_device rd;
std::mt19937 gen(rd());
std::uniform_int_distribution<int> dis(0, NUM_TESTS);

TEST(TestSort, TestBubbleSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::bubble_sort::sort<int>(arr);
  EXPECT_EQ(arr, arr_sorted);
}

TEST(TestSort, TestSelectionSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::selection_sort::sort<int>(arr);
  EXPECT_EQ(arr, arr_sorted);
}

TEST(TestSort, TestInsertionSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::insertion_sort::sort<int>(arr);
  EXPECT_EQ(arr, arr_sorted);
}

TEST(TestSort, TestHeapSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::heap_sort::sort<int>(arr);
  EXPECT_EQ(arr, arr_sorted);
}

TEST(TestSort, TestMergeSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::merge_sort::sort<int>(arr, 0, arr.size() - 1);
  EXPECT_EQ(arr, arr_sorted);
}

TEST(TestSort, TestQuickSort) {
  std::vector<int> arr(NUM_TESTS);
  std::generate(arr.begin(), arr.end(), [&](){return dis(gen);});
  std::vector<int> arr_sorted = arr;
  std::sort(arr_sorted.begin(), arr_sorted.end());
  sort::quick_sort::sort<int>(arr, 0, arr.size() - 1);
  EXPECT_EQ(arr, arr_sorted);
}

int main() {
  ::testing::InitGoogleTest();
  std::vector<int> arr = {10, 2, 6, 4, 5, 1};
  sort::quick_sort::sort<int>(arr, 0, arr.size() - 1);
  return RUN_ALL_TESTS();
}