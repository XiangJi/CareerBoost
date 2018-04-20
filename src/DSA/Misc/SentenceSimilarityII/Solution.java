package DSA.Misc.SentenceSimilarityII;

import java.util.HashMap;
import java.util.Map;

/*
 * This is a good use case for Union-Find, compare to Sentence Similarity I, here the similarity between words are transitive, so all the connected(similar) words should be group into an union represented by their ultimate parent(or family holder, you name it).
The connections can be represented by an parent map Map<String, String> m, which record the direct parent-ship we learned in each pair, but not the ultimate-parent. To build it, go through the input pairs, for each pair<w1, w2>, use the recursive find() method to find the ultimate-parent for both word - parent1, parent2, if they are different, assign parent1 as parent of parent2(or the other way around), so that the to families are merged.
The classic find(x) method will find the ultimate-parent of x. I modified it a little bit, make it do a little of extra initialization work - assign x itself as its parent when it is not initialize - so that we don’t have to explicitly initialize the map at the beginning.

 */
class Solution {
    public boolean areSentencesSimilarTwo(String[] a, String[] b, String[][] pairs) {
        if (a.length != b.length) return false;
        Map<String, String> m = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(m, p[0]), parent2 = find(m, p[1]);
            if (!parent1.equals(parent2)) m.put(parent1, parent2);
        }

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]) && !find(m, a[i]).equals(find(m, b[i]))) return false;

        return true;
    }

    private String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
}