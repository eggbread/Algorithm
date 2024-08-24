#ifndef BUBBLE_SORT_H
#define BUBBLE_SORT_H

#include <vector>

namespace sort {
    namespace bubble_sort {
        template <typename T>
        void sort(std::vector<T>& arr) {
            for (size_t i = 0; i < arr.size(); i++) {
                for (size_t j = 0; j < arr.size() - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        std::swap(arr[j], arr[j + 1]);
                    }
                }
            }
        }
    } // namespace bubble_sort
} // namespace sort

#endif // BUBBLE_SORT_H