package DSA.Tree.ConstructBinaryTreefromPreorderandPostorderTraversal;

import DSA.Tree.TreeNode;

// 1, 2, 3, 4, 5, 6 ,7 关键是找到left的长度
// 把pre的第一个去post里面扫 就找到了left长度

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0 || post.length == 0 || pre.length != post.length)
            return null;
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    private TreeNode dfs(int[] pre, int ps, int pe, int[] post, int pps, int ppe) {
        if(ps > pe || pps > ppe) return null;
        TreeNode root = new TreeNode(pre[ps]); // 定义开始root
        if(ps + 1 > pe) return root; // 退出条件
                // this is the start of the left tree
        int val = pre[ps + 1], index = 0;
        for(int i = pps; i <= ppe; i++) {
            if(post[i] == val) {
               index = i;  
            }
        }
        root.left = dfs(pre, ps + 1, ps + index - pps + 1, post, pps, index); // 找到了长度
        root.right = dfs(pre, ps + index - pps + 2, pe, post, index + 1, ppe - 1);
        return root;
    }
}