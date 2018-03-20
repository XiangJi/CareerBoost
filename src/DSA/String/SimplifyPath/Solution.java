package DSA.String.SimplifyPath;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

简化path 并不是前面的都不要
路径题一般都是用stack去做
F, M
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.simplifyPath("/a/./b/../../c/"));
        System.out.println(test.simplifyPath("/home/"));
        System.out.println(test.simplifyPath("/../"));
    }
}