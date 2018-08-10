package DSA.Tree.EraseNode;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

/*
 *
Tree Eraser.
Given a binary tree, where each node has a "left" and "right" pointers,  and a predicate shouldBeErased(Node n) function, output the forest (collection of trees) created by erasing the nodes indicated by shouldBeErased().
Example:
     F
    / \
   /   \  .
[B]    G
/ \     \
A   D    [I]
   / \   /
  C   E H   .

In this example shouldBeErased() returns true for nodes B & I and false for the other nodes, the resulting forest is : [ A, D, F, H ].
A  F      D    H
    \    / \
     G  C   E

public Node(String name, Node left, Node right) {
    this.name = name;
    this.left = left;
    this.right = right;
  }
  public String name;
  public Node left;
  public Node right;
}

// public static boolean shouldBeErased(Node n)
 *
 *post order parent
 */
public class Solution {
    public List<Integer> findForest(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return res;
    }

    public TreeNode dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return root;
        }
        TreeNode left = dfs(root.left, res);
        TreeNode right = dfs(root.right, res);
        if (shouldBeErased(root)) {
            if (left != null) res.add(root.left.val);
            if (right != null) res.add(root.right.val);
            return null;
        } else {
            return root;
        }
    }

    public static boolean shouldBeErased(TreeNode node) {
        return true;
    }
}
