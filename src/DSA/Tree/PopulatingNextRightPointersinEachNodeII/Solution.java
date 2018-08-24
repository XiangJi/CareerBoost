package DSA.Tree.PopulatingNextRightPointersinEachNodeII;

import DSA.Tree.TreeLinkNode;

/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
    not perfect full binary tree this time
    
    直接用多个指针来实现
    dummy一直作为远程dummy
    pre 一直往后连
    root 一直层序往后
 */
public class Solution {
    
    public void connectII(TreeLinkNode root) { 
        if (root == null || root.left == null) { // perfect binary tree. Only checking for one child
            return;
        }
        
        root.left.next = root.right;
        TreeLinkNode next = root.right.next;
        if (root.left.right != null) {  // check if we have another level below us
            root.left.right.next = root.right.left;
            if (next != null) {
                root.right.right.next = next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
    }
    // 巧妙有意思！
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode cur = root;
        TreeLinkNode pre = dummy;
        while (cur != null) {
            if (cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if (cur.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            cur = cur.next;
            if (cur == null) {
                pre = dummy;
                cur = dummy.next;
                dummy.next = null;
            }
            
        }
    }

}
