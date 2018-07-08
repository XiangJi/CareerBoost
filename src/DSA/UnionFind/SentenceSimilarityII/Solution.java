package DSA.UnionFind.SentenceSimilarityII;

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
        // 非数字的图node 用hashmap来替代array存
        Map<String, String> root = new HashMap<>();
        // 构图UnionFind
        for (String[] p : pairs) {
            String parent1 = find(root, p[0]), parent2 = find(root, p[1]);
            if (!parent1.equals(parent2)) {
                root.put(parent1, parent2);
            }
        }

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]) && !find(root, a[i]).equals(find(root, b[i]))) {
                return false;
            }

        return true;
    }
    // recursive to replace the while loop
    private String find(Map<String, String> root, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
        }
        return s.equals(root.get(s)) ? s : find(root, root.get(s));
    }
}