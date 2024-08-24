#ifndef SELECTION_SORT_H
#define SELECTION_SORT_H

#include <vector>

namespace sort {
    namespace selection_sort {
        template <typename T>
        void sort(std::vector<T>& arr) {
            for (size_t i = 0; i < arr.size(); i++) {
                size_t min_index = i;
                for (size_t j = i + 1; j < arr.size(); j++) {
                    if (arr[j] < arr[min_index]) {
                        min_index = j;
                    }
                }
                std::swap(arr[i], arr[min_index]);
            }
        }
    } // namespace selection_sort
} // namespace sort

#endif // SELECTION_SORT_H