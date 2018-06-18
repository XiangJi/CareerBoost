package DSA.UnionFind.GraphValidTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

DFS, BFS, Union Find

推荐用Union Find 写

判断是非有环 典型得判断动态图联通性的问题
对Union find 理解很重要

T:O (N + E)
S: O(N)

电面题：二叉树多了一条边 找到这条边 删掉
O(1) find, union, o(n) construct

当 x==y 时候 这条边多余 删掉就好了edge[0] edge[1]
 */
class Solution {
    // union find, 这边只需要find就可以解题
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (n < 1 || edges == null || edges.length != n - 1) return false;
        // 只需要parent 数组
        int[] parent  = new int[n];

        // initialization,一开始所有
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);
            if (x == y) {
                return false; // connected
            }
            parent[y] = x; // parent[x] = y also works, just make sure has one mark direction
        }
        return true;
    }

    private int find(int node, int[] parent) {
        while (parent[node] != -1) {
            node = parent[node];
        }
        return node;
    }

    // DFS
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        // 常见构图代码
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        return visited.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent) continue;
            if (visited.contains(v)) return false;
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (res == false) return false;
        }
        return true;
    }

}