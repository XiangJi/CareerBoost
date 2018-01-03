package DSA.Tree.TwoSuminBST;

import java.util.HashSet;

import DSA.Tree.TreeNode;

/*
 * Find two sum in BST 
 * (1) Use hash set to keep those visited value for fast lookup.
 * – It can be applied to any kinds of tree. Time/Space: n/n
 * (2) Dump values to array list in-order and search by the way just like in 2sum.
 * – Time/Space: n/n
 * (3) Use the stack and search just like 2sum without dumping all the value out in the beginning.
 * – Time/Space: n/logn in average
 * (4) BFS and Set
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    
    private boolean dfs(TreeNode current, int k, HashSet<Integer> set) {
        if (current == null) {
            return false;
        }
        if (set.contains(k - current.val)) {
            return true;
        }
        set.add(current.val);
        return dfs(current.left, k, set) || dfs(current.right, k, set);
    }
}