#ifndef BFS_H
#define BFS_H

#include <queue>

namespace search {
    namespace bfs {
        template <typename T>
        void search(std::vector<std::vector<T>>& graph, size_t start) {
            std::vector<bool> visited(graph.size(), false);
            std::queue<size_t> q;

            visited[start] = true;
            q.push(start);

            while (!q.empty()) {
                size_t current = q.front();
                q.pop();

                for (size_t i = 0; i < graph[current].size(); i++) {
                    if (!visited[i] && graph[current][i]) {
                        visited[i] = true;
                        q.push(i);
                    }
                }
            }
        }
    } // namespace bfs
} // namespace search

#endif // BFS_H