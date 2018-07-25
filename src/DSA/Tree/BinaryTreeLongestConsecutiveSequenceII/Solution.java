package DSA.Tree.BinaryTreeLongestConsecutiveSequenceII;

import DSA.Tree.TreeNode;

/*
 * 那道题只让从父结点到子结点这种顺序来找最长连续序列，而这道题没有这个顺序限制，我
 * 们可以任意的拐弯，这样能找到最长的递增或者递减的路径。
 * 当然是从叶结点算起，这样才方便往根结点回溯。当某个结点比其父结点值大1的话，
 * 说明这条路径是递增的，那么当我们知道其左右子结点各自的递增路径长度，那么当前结点的递增路径
 * 长度就是左右子结点递增路径长度中的较大值加上1，同理如果是递减路径，那么当前结点的递减路径长度就是
 * 左右子结点递减路径长度中的较大值加上1，通过这种方式我们可以更新每个结点的递增递减路径长度。在回溯
 * 的过程中， 一旦我们知道了某个结点的左右子结点的最长递增递减路径长度，那么我们可以算出当前结点的长
 * 连续序列的长度， 要么是左子结点的递增路径跟右子结点的递减路径之和加1，要么事左子结点的递减路径跟
 * 右子结点的递增路径之和加1，二者中取较大值即可
 * G tag
 *
 * 同时track两个 inr dcr 放在返回值里面传
 * post order 拿到左右节点的返回值再更新
 */
class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[] {0, 0};
        }
        int ins = 1, des = 1;
        if (cur.left != null) {
            int[] l = dfs(cur.left);
            if (cur.val == cur.left.val + 1) {
                des = l[1] + 1;
            } else if (cur.val == cur.left.val - 1) {
                ins = l[0] + 1;
            }
        }
        if (cur.right != null) {
            int[] r = dfs(cur.right);
            if (cur.val == cur.right.val + 1) {
                des = Math.max(des, r[1] + 1); // 注意这边要更新, 而不是简单的 + 1了
            } else if (cur.val == cur.right.val - 1) {
                ins =  Math.max(ins, r[0] + 1);
            }
            
        }
        max = Math.max(max, ins + des - 1);
        return new int[] {ins, des};
    }
}