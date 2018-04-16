package DSA.UnionFind;

public class UnionFindSet {
    private int[] parents;
    private int[] ranks;
   
    public UnionFindSet(int n) {
        parents = new int[n + 1];
        ranks = new int[n + 1];
        for (int i = 0; i < parents.length; ++i) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }
   
    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv) return false;
   
        if (ranks[pv] > ranks[pu])
            parents[pu] = pv;           
        else if (ranks[pu] > ranks[pv])
            parents[pv] = pu;
        else {
            parents[pv] = pu;
            ranks[pu] += 1;
        }
   
        return true;
    }
   
    public int Find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }
  }