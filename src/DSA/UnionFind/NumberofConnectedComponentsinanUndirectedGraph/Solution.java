package DSA.UnionFind.NumberofConnectedComponentsinanUndirectedGraph;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 *  (each edge is a pair of nodes), write a function to find the number of connected
 *  components in an undirected graph.
Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges
 are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Same as 261

无向图
每个component： nodes - edges = 1
result n = 5, traverse all the edges,
if no loop n--, then n is the result
if no loop, n 不变
 */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = n;

        int[] parent  = new int[n];

        // initialization
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);
            if (x != y) {
                // no loop
                result--;
                parent[y] = x; // parent[x] = y also works, just make sure has one mark direction
            }

        }
        return result;
    }

    private int find(int node, int[] parent) {
        while (parent[node] != -1) {
            node = parent[node];
        }
        return node;
    }
}
