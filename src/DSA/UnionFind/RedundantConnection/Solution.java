package DSA.UnionFind.RedundantConnection;

/*
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values
1, 2, ..., N), with one additional edge added. The added edge has two different
 vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges.
Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes.
If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

 Union Find

 No cycle, remove the cycle edges

 * NlogN, if union by rank, and path compression, goes to O(N)
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        // init
        for(int i = 0; i < parent.length; i++){
          parent[i] = i;
        }
        // traverse and find
        for(int[] e: edges){
          int u = e[0], v = e[1];
          int ru = find(parent, u);
          int rv = find(parent, v);
          if(ru == rv){
            return e;
          } else {
            parent[ru] = rv;
          }
        }
        return new int[2];
    }

    private int find(int[] parent, int i) {
        while ( i != parent[i]) { // if not when init as the node itself
            i = parent[i];
        }
        return i;
    }
}