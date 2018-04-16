package DSA.Misc.SentenceSimilarityII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, Integer> index = new HashMap();
        int count = 0;
        DSU dsu = new DSU(2 * pairs.length);
        for (String[] pair : pairs) {
            for (String p : pair)
                if (!index.containsKey(p)) {
                    index.put(p, count++);
                }
            dsu.union(index.get(pair[0]), index.get(pair[1]));
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            if (w1.equals(w2))
                continue;
            if (!index.containsKey(w1) || !index.containsKey(w2) || dsu.find(index.get(w1)) != dsu.find(index.get(w2)))
                return false;
        }
        return true;
    }
}

class DSU {
    int[] parent;

    // init
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }
    // find
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    //union
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}