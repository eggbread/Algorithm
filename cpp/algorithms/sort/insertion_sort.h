#ifndef INSERTION_SORT_H
#define INSERTION_SORT_H

#include <vector>

namespace sort {
    namespace insertion_sort {
        template <typename T>
        void sort(std::vector<T>& arr) {
            for (size_t i = 1; i < arr.size(); i++) {
                T key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
    } // namespace insertion_sort
} // namespace sort

#endif // INSERTION_SORT_H