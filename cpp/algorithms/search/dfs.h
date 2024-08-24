#ifndef DFS_H
#define DFS_H

#include <vector>
#include <stack>

namespace search {
    namespace dfs {
        template <typename T>
        void search(std::vector<std::vector<T>>& graph, std::vector<bool>& visited, size_t node) {
            std::vector<bool> visited(graph.size(), false);
            std::stack<size_t> s;
            s.push(start);

            while (!s.empty()) {
                size_t node = s.top();
                s.pop();

                if (!visited[node]) {
                    visited[node] = true;
                    for (size_t i = 0; i < graph[node].size(); i++) {
                        if (!visited[i] && graph[node][i] != 0) {
                            s.push(i);
                        }
                    }
                }
            }
        }
    } // namespace dfs
} // namespace search

#endif // DFS_H