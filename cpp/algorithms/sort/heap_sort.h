#ifndef HEAP_SORT_H
#define HEAP_SORT_H

#include <vector>

namespace sort {
    namespace heap_sort {
        template <typename T>
        void heapify(std::vector<T>& arr, size_t n, size_t i) {
            size_t largest = i;
            size_t l = 2 * i + 1;
            size_t r = 2 * i + 2;

            if (l < n && arr[l] > arr[largest]) {
                largest = l;
            }

            if (r < n && arr[r] > arr[largest]) {
                largest = r;
            }

            if (largest != i) {
                std::swap(arr[i], arr[largest]);
                heapify(arr, n, largest);
            }
        }

        template <typename T>
        void sort(std::vector<T>& arr) {
            size_t n = arr.size();

            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            for (int i = n - 1; i >= 0; i--) {
                std::swap(arr[0], arr[i]);
                heapify(arr, i, 0);
            }
        }
    } // namespace heap_sort
} // namespace sort

#endif // HEAP_SORT_H