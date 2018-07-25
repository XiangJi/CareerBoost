package DSA.Tree.SimiliarTree;

import DSA.Tree.TreeNode;

/*
 * 判断两个input tree是不是similar, similar 的definition是两棵树任一结点可以通过swap左右子树后相等。

判断2个BT 是不是 similar. similar的定义是 可以任意swap一个node的两个children (children 的children会跟着一起swap）


time 应该是O(max(n, m)), 每个node除了root最多被compare 2次

https://www.geeksforgeeks.org/tree-isomorphism-problem/

We simultaneously traverse both trees. Let the current internal nodes of two trees being traversed be n1 and n2 respectively. There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
1) Data of n1 and n2 is same.
2) One of the following two is true for children of n1 and n2
……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2.
……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.

 */
public class Solution {
    /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(TreeNode n1, TreeNode n2)
    {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null)
            return true;

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null)
            return false;

        if (n1.val != n2.val)
            return false;

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been
        // "Flipped".
        // Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(n1.left, n2.left) &&
                                         isIsomorphic(n1.right, n2.right))
        || (isIsomorphic(n1.left, n2.right) &&
                                         isIsomorphic(n1.right, n2.left));
    }
}

