package DSA.UnionFind.RedundantConnectionII;
/*
 * 和上一题一样 但是是有向图
 * every node has exactly one root, except for the root node which has no roots.
 * 画图分类讨论用并查集
 * Case 1 没有点有两个点指向它，即没有duplicate roots -> return the first edge that creates the loop, just like redundant connection I
 * Case 2.1 有重复root 没有单向环， 则删除第二条重复root边
 * Case 2.2 有重复root 而且有单向环， 删除在环里面的重复root边
 * 
 * 
 * Union find: O(nlogn) ~ o(n), S: o(n)
 */
public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] root = new int[edges.length + 1];
        // first scan, for case 2
        for (int i = 0; i < edges.length; i++) {
            // init root for all the pointed-to nodes
            if (root[edges[i][1]] == 0) {
                root[edges[i][1]] = edges[i][0];
            } else {
                // in this case, duplites parents, both this one and old can be candidates
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {root[edges[i][1]], edges[i][1]};
                edges[i][1] = 0; // remove this edge by now
            }
        }
        // second scan, re-init root array
        for (int i = 0; i < edges.length; i++) {
            root[i] = i;
        }
        // Union find
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue; // skip case two
            } 
            int child = edges[i][1], father = edges[i][0];
            if (find(root, father) == child) {
                if (can1[0] == -1) { // no dup situation
                    return edges[i];
                }
                return can1; // return old edge, which is the one create the loop case 2,2,
            }
            root[child] = father;// if no loop this time, keep assign things 
        }
        return can2; // return new edge, case 2.1
    }
    
    private int find(int[] root, int i) {
        while (i != root[i]) {
            i = root[i];
        }   
        return i;
    }
}
