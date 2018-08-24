package DSA.Tree.ConstructBinaryTreefromPreorderandPostorderTraversal;

import DSA.Tree.TreeNode;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0 || post.length == 0 || pre.length != post.length)
            return null;
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    private TreeNode dfs(int[] pre, int ps, int pe, int[] post, int pps, int ppe) {
        if(ps > pe || pps > ppe) return null;
        TreeNode root = new TreeNode(pre[ps]);
        if(ps + 1 > pe) return root;
                // this is the start of the left tree
        int val = pre[ps + 1], idx = pps;
        for(; idx < ppe; idx++) {
            if(post[idx] == val) break;
        }
        root.left = dfs(pre, ps + 1, ps + idx - pps + 1, post, pps, idx);
        root.right = dfs(pre, ps + idx - pps + 2, pe, post, idx + 1, ppe - 1);
        return root;
    }
}