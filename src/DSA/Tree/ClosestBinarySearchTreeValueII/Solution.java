package DSA.Tree.ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?


The idea is to compare the predecessors and successors of the closest node to the target, we can use two stacks to track the predecessors and successors, then like what we do in merge sort, we compare and pick the closest one to the target and put it to the result list.

As we know, inorder traversal gives us sorted predecessors, whereas reverse-inorder traversal gives us sorted successors.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>(), succ = new Stack<>();
        initStack(pred, succ, root, target);
        while(k-- > 0){
            if(succ.isEmpty() || !pred.isEmpty() && target - pred.peek().val < succ.peek().val - target){
                list.add(pred.peek().val);
                getPredecessor(pred);
            }
            else{//Since N > k, always have something to add
                list.add(succ.peek().val);
                getSuccessor(succ);
            }
        }
        return list;
    }

    private void initStack(Stack<TreeNode> pred, Stack<TreeNode> succ, TreeNode root, double target){
        while(root != null){
            if(root.val <= target){
                pred.push(root);
                root = root.right;
            }
            else{
                succ.push(root);
                root = root.left;
            }
        }
    }
    private void getPredecessor(Stack<TreeNode> st){
        TreeNode node = st.pop();
        if(node.left != null){
            st.push(node.left);
            while(st.peek().right != null)  st.push(st.peek().right);
        }
    }
    private void getSuccessor(Stack<TreeNode> st){
        TreeNode node = st.pop();
        if(node.right != null){
            st.push(node.right);
            while(st.peek().left != null)   st.push(st.peek().left);
        }
    }
    
    // BF use heap, trival
    
    // In-order recursive traversal and maintaining a size k LinkedList which is sorted because of in-order
    public List<Integer> closestKValuesII(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        closestKValuesHelper(root, target, k, list);
        return list;
    }
    private void closestKValuesHelper(TreeNode root, double target, int k, LinkedList<Integer> list){
        if(root == null || list.size() == k && list.get(0) >= target)    return;
        closestKValuesHelper(root.left, target, k, list);
        if(list.size() == k && list.get(0) < target && target - list.get(0) > Math.abs(root.val - target)){
            list.removeFirst();
            list.addLast(root.val);
        }
        else if(list.size() < k)    list.addLast(root.val); 
        closestKValuesHelper(root.right, target, k, list);
    }
}
