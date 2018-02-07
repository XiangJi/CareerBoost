# Union Find (Forest), Disjoint Set

数据结构 也是算法

Find(x): find the root of x    约等于 O(1)

Union(x, y) : merge two clusters 约等于 O(1)

Space O(N)

8->5->3->1 到自己

4 ->2 到自己



优化手段

Path compression: make tree flat   (happens during Find)

Union by rank: merge low rank tree to high rank one

rank是平均树长度

union会把低rank数merge到高rank树





Reference: 花花酱 Disjoint-set/Union-find Forest - 刷题找工作 SP1

https://www.youtube.com/watch?v=VJnUwsE4fWA&list=PLLuMmzMTgVK5Hy1qcWYZcd7wVQQ1v0AjX



需要有UnionFindSet 模板数据结构

```java
class UnionFind {
        private int count = 0;
        private int[] parent, rank;
        
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

