#ifndef MERGE_SORT_H
#define MERGE_SORT_H

#include <vector>

namespace sort {
    namespace merge_sort {
        template <typename T>
        void merge(std::vector<T>& arr, size_t l, size_t m, size_t r) {
            size_t n1 = m - l + 1;
            size_t n2 = r - m;

            std::vector<T> L(n1);
            std::vector<T> R(n2);

            for (size_t i = 0; i < n1; i++) {
                L[i] = arr[l + i];
            }

            for (size_t i = 0; i < n2; i++) {
                R[i] = arr[m + 1 + i];
            }

            size_t i = 0;
            size_t j = 0;
            size_t k = l;

            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        template <typename T>
        void sort(std::vector<T>& arr, size_t l, size_t r) {
            if (l < r) {
                size_t m = l + (r - l) / 2;
                sort(arr, l, m);
                sort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }
    }
}

#endif // MERGE_SORT_H