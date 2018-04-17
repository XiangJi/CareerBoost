# Union Find (Forest), Disjoint Set

数据结构 也是算法

常被用于两个点是否联通，连通性问题

有向图上面是否有环

处理一些不相交集合（Disjoint Sets UnionFind）的合并及查询问题。常常在使用中以森林来表示。 进行快速规整。

Find(x): find the root of x    约等于 O(1)

Union(x, y) : merge two clusters 约等于 O(1)

Space O(N)

8->5->3->1 到自己

4 ->2 到自己



优化手段

Path compression: make tree flat   (happens during Find)

Union by rank: merge low rank tree to high rank one

rank是平均树长度 深度

union会把低rank数merge到高rank树



1,初始化一个并查集 initUnionFind
初始化并查集,一般是将每个元素作为一个单独的集合,对于下面的示例就是对应的元素父节点就是自己

2,合并两个不相交集合 union
两个元素,分别找到(find)他们的根节点,然后将其中一个元素的根节点的父亲指向另外的一个元素的根节点

3,查找某个元素的根节点 find
查找一个元素的根节点,parent--->parent--->parent.....
那么问题来了,查找元素根节点途径的元素过多,那么就有一个优化的问题-------路径压缩,直接将该元素的父亲指向根节点或者祖先

4,判断两个元素是否属于同一个集合 isConnected
判断两个元素是否属于同一个集合,就是分别找到他们的根节点,然后判断两个根节点是否相等.





Reference: 花花酱 Disjoint-set/Union-find Forest - 刷题找工作 SP1

https://www.youtube.com/watch?v=VJnUwsE4fWA&list=PLLuMmzMTgVK5Hy1qcWYZcd7wVQQ1v0AjX



需要有UnionFindSet 模板数据结构, 不同的题目需要的UF模板可以功能简化

```java
class UnionFind {
        private int count = 0; // WEIGHT
        private int[] parent, rank; // RANK IS FOR PATH COMPRESSION
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
        	while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
```

![1339478916_8193-1](http://jbcdn2.b0.upaiyun.com/2016/11/58d4e2da4360c22a359eb55836e795e2.png)



- 给出两个节点，判断它们是否连通，如果连通，不需要给出具体的路径
- 给出两个节点，判断它们是否连通，如果连通，需要给出具体的路径

就上面两种问题而言，虽然只有是否能够给出具体路径的区别，但是这个区别导致了选择算法的不同，本文主要介绍的是第一种情况，即不需要给出具体路径的Union-Find算法，而第二种情况可以使用基于DFS的算法。



在《算法第四版》第一章的1.5中给出了union-find三种不同实现：

> - quick-find
> - quick-union
> - 加权quick-union

| Algorithm                                  | Constructor | Union                      | Find                       |
| ------------------------------------------ | ----------- | -------------------------- | -------------------------- |
| Quick-Find                                 | N           | N                          | 1                          |
| Quick-Union                                | N           | Tree height                | Tree height                |
| Weighted Quick-Union                       | N           | lgN                        | lgN                        |
| Weighted Quick-Union With Path Compression | N           | Very near to 1 (amortized) | Very near to 1 (amortized) |

如果需要的功能不仅仅是检测两个节点是否连通，还需要在连通时得到具体的路径，那么就需要用到别的算法了，比如DFS或者BFS。