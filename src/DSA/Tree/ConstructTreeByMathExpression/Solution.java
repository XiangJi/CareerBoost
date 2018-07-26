package DSA.Tree.ConstructTreeByMathExpression;

import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * 字符串转为二叉树 输入是一个字符串
一个数组 数组里存着加减乘除的顺序 可能是+-* / 可能是* - + /之类的 

比如给你个1 * 9 - 3 +2 *7

让你转成

                   +
                  /  \ .
               /\    /\
              *  3  2  7
             /\
            1  9
普通递归dfs大家都会

String已经是中序遍历了 主要是找根 要把符号放在数字上面
Hard题
 */
public class Solution {
 
    // A utility function to check if 'c'
    // is an operator
 
    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
 
    // Utility function to do inorder traversal
    void inorder(TreeNode t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.val + " ");
            inorder(t.right);
        }
    }
 
    // Returns root of constructed tree for given
    // postfix expression
    TreeNode constructTree(char postfix[]) {
        Stack<TreeNode> st = new Stack();
        TreeNode t, t1, t2;
 
        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {
 
            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new TreeNode(postfix[i]);
                st.push(t);
            } else // operator
            {
                t = new TreeNode(postfix[i]);
 
                // Pop two top nodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();
 
                //  make them children
                t.right = t1;
                t.left = t2;
 
                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }
 
        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();
 
        return t;
    }
 
    public static void main(String args[]) {
 
        Solution et = new Solution();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        TreeNode root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
 
    }
}
