#ifndef QUICK_SORT_H
#define QUICK_SORT_H

#include <vector>

namespace sort {
    namespace quick_sort {
        template <typename T>
        int partition(std::vector<T>& arr, int low, int high) {
            T pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    std::swap(arr[i], arr[j]);
                }
            }

            std::swap(arr[i + 1], arr[high]);
            return i + 1;
        }

        template <typename T>
        void sort(std::vector<T>& arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
        }
    } // namespace quick_sort
} // namespace sort

#endif // QUICK_SORT_H