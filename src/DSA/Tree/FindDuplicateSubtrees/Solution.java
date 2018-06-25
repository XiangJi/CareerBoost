package DSA.Tree.FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

Intuitive:

存储表示二叉树必须serialized

LC 297 serialize and deserialize binary tree

serialize root
if root == null return #
String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);

Solution 1:
Use hashtable to count a serialized subtree HashMap<String, count>

T(N^2) where NN is the number of nodes in the tree.
We visit each node once, but each creation of serial may take O(N)O(N) work.

Solution 2: optimze

面经：find the number of subtree， use a number to count, just res++

 */
class Solution {
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }

    // Optimize
    /* Assign each unique subtree a unique id
     * Suppose we have a unique identifier for subtrees: two subtrees are the same if and only if they have the same id.
     * Then, for a node with left child id of x and right child id of y, (node.val, x, y) uniquely determines the tree.
     * Algorithm
     * If we have seen the triple (node.val, x, y) before, we can use the identifier we've remembered. Otherwise, we'll create a new one.
     */
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> cnt; // id, count
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtreesII(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        cnt.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            result.add(node);
        return uid;
    }

}