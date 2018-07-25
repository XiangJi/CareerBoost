package DSA.Tree.kthElementinaTree;
/*
 * kth element in a tree. 每个Node中包含有所有子节点的个数
 *
 * kth is for in-order
 *
 * 给定一个二叉树,每一个节点里记录了其下有多少个子节点，求第k个inorder position.
 *
 * 不是BST，就是普通的binary tree。这个find kth element call会调用多次。面试官的意思是，你一开始可以用O(n)时间遍历下树，给每个树加一个count变量，代表这个节点有多少个子节点。这样以后就可以用O（logn）的时间进行查询了。所有过程不算recursion的stack空间，其它都要求空间是O（1）的。所以不能中序遍历存到某个数组里，再查询。
 *
 *查询是logN的
 */
public class Solution {
    // Solution 1: just inorder and count, when kth, just return

    // Solution 2 , first inorder to count the sum of these left, then binary search
}
